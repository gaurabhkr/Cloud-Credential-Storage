package com.tel.CloudCreden.Config;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.tel.CloudCreden.Models.Userlogin;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	private String secretkey;
	
	//one min token
	public String genratetoken(Userlogin u) {
		Map<String,Object> claims=new HashMap<>();
		return Jwts.builder()
				.claims().add(claims)
				.subject(u.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+2*60*1000))
				.and().
				signWith(getkey()).
				compact();
	}
	private SecretKey getkey() {
		byte[] keybytes=Decoders.BASE64.decode(secretkey);
		return Keys.hmacShaKeyFor(keybytes);
	}
	
	private JwtService() throws NoSuchAlgorithmException {
		KeyGenerator keygen=KeyGenerator.getInstance("HmacSHA256");
		SecretKey seckey=keygen.generateKey();
		secretkey=Base64.getEncoder().encodeToString(seckey.getEncoded());
	}
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	
	private <T> T extractClaim(String token,Function<Claims,T> claimResolver) {
		final Claims claims=extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(getkey()).build().parseSignedClaims(token).getPayload();
	}
	
	public boolean validatetoken(String token,UserDetails userdetails) {
		final String userName=extractUsername(token);
		return (userName.equals(userdetails.getUsername())&& !istokenexpired(token));
	}
	
	private boolean istokenexpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	private Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
}
