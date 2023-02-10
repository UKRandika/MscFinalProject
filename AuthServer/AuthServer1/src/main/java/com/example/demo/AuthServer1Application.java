package com.example.demo;

import com.example.demo.Models.UserD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.Services.userService;
@SpringBootApplication
public class AuthServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(AuthServer1Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(userService userService){
//		return args -> {
//			UserD u = userService.userByEmail("admin@gmail.com");
//			if(u.getEmail() != null){
//
//			}else {
//				userService.Registration(new UserD(null,"Admin", null,"admin@gmail.com","admin@gmail.com",null,"ADMIN_ROLE","12345678",null, null,false));
//			}
//		};
//	}
}
