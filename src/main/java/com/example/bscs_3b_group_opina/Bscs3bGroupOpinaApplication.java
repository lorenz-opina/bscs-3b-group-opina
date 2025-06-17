package com.example.bscs_3b_group_opina;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Bscs3bGroupOpinaApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(Bscs3bGroupOpinaApplication.class)
				.headless(false)
				.run(args);

		System.out.println("Hello from main");
	}

}
