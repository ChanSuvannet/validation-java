package com.exam.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String port = environment.getProperty("server.port", "8080");
		String message = String.format(
				"\u001B[32mSpring Boot application running on host: \u001B[34mhttp://localhost:%s\u001B[37m", port);
		System.out.println(message);
	}
}
