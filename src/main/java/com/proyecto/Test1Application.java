package com.proyecto;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyecto.security.JWTAuthorizationFilter;
import com.proyecto.util.utiles;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
@EnableScheduling
public class Test1Application  extends SpringBootServletInitializer { 
	 private static final Logger logger = LogManager.getLogger(Test1Application.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);	
		utiles util = new utiles();		
		try {
			util.readFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		  java 8 lambda, no need to check log level
//		 logger.debug("from Log4j 2 - producto : {}", () -> producto)
	}	
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/api/login").permitAll()
				.anyRequest().authenticated();
		}
	}
	
	
}
