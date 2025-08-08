package com.tel.CloudCreden.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	public UserDetailsService UserDetailService;
	
	@Autowired
	public JWTFilter jwtfilter;
	
	
	@Bean
		public SecurityFilterChain securtiyfilterchain(HttpSecurity http) throws Exception {
			
			http.csrf(Customizer->Customizer.disable());
			
//			http.formLogin(Customizer.withDefaults());
			
			http.httpBasic(Customizer.withDefaults());
			
			http.authorizeHttpRequests(Request->Request.requestMatchers("login","register").permitAll().anyRequest().authenticated());
			
			http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			
			http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
			
			return http.build();
		}
	
	
	
	//All are working but not in formlogin and httplogin
	@Bean
	public AuthenticationProvider authenticationprovider() {
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		provider.setUserDetailsService(UserDetailService);
		
		return provider;
	}
	
	
	
	@Bean
	public AuthenticationManager authenticationmanger(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
}
