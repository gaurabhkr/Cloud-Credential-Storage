package com.tel.CloudCreden.Config;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class EncryptService {
	
	public String messag(String text) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		SecretKey key=genratekey(128);
		GCMParameterSpec gcmparameter=generateiv();
		String algoritm="AES/GCM/Nopadding";
		String encrypttext=encrypt(algoritm, text, key, gcmparameter);
		String decrypttext=decrypt(algoritm, encrypttext, key, gcmparameter);
		return decrypttext;
		}
	
	
	
	public SecretKey genratekey(int n) throws NoSuchAlgorithmException {
		KeyGenerator keygenerator=KeyGenerator.getInstance("AES");
		keygenerator.init(n);
		SecretKey key=keygenerator.generateKey();
		return key;
	}
	
	
	
	public GCMParameterSpec generateiv() {
		byte[] iv=new byte[12];
		new SecureRandom().nextBytes(iv);
		return new GCMParameterSpec(128, iv);
	}
	
	
//	public SecretKey getkeypassword(String password,String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
//		SecretKeyFactory factory=SecretKeyFactory.getInstance("");
//		KeySpec keyspec=new PBEKeySpec(password.toCharArray(),salt.getBytes(),65536,256);
//		SecretKey secret=new SecretKeySpec(factory.generateSecret(keyspec).getEncoded(),"AES");
//	return secret;
//	}
	
	
	public String encrypt(String algorithm,String input,SecretKey key,GCMParameterSpec iv) 
	throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
	InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		Cipher cipher=Cipher.getInstance(algorithm);
		
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		
		byte[] cipherText=cipher.doFinal(input.getBytes());
		
		return Base64.getEncoder().encodeToString(cipherText);
	}

	
	
	public String decrypt(String algorithm,String ciphertext,SecretKey key,GCMParameterSpec iv) 
		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
		InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException { 
	Cipher cipher=Cipher.getInstance(algorithm);
	cipher.init(cipher.DECRYPT_MODE, key,iv);
	byte[] plaintext=cipher.doFinal(Base64.getDecoder().decode(ciphertext));
	return new String (plaintext);
}

}
