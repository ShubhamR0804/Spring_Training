package com.techlabs.bank.config;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techlabs.bank.security.JwtAuthenticationEntryPoint;
import com.techlabs.bank.security.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@EnableMethodSecurity
@Configuration
@AllArgsConstructor
@RequiredArgsConstructor
public class SecurityConfig   {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	  SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
	    http.csrf(csrf -> csrf.disable()).cors(withDefaults());
	    http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));
	    
	   // http.authorizeHttpRequests(request -> request.requestMatchers("/api/register").permitAll());
	    http.authorizeHttpRequests(request -> request.requestMatchers("/api/login").permitAll());
	    
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST,"/api/register"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET, "/admin/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/admin/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.PUT, "/admin/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.DELETE, "/admin/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET, "/customer/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/customer/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.PUT, "/customer/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.DELETE, "/customer/**"));
	    http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
	    http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	    http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
	    return http.build();
	  }
	
}
