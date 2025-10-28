package com.jei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class
UsuarioMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioMSApplication.class, args);
	}

}
