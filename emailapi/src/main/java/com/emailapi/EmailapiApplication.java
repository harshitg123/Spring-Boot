package com.emailapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class EmailapiApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();

		System.setProperty("EMAIL_FROM", dotenv.get("EMAIL_FROM"));
		System.setProperty("EMAIL_PWD", dotenv.get("EMAIL_PWD"));

		SpringApplication.run(EmailapiApplication.class, args);
	}

}
