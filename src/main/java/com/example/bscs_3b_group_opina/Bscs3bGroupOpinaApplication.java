package com.example.bscs_3b_group_opina;

import com.example.bscs_3b_group_opina.server.Controller.Server;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Bscs3bGroupOpinaApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(Bscs3bGroupOpinaApplication.class)
				.headless(false)
				.run(args);

		System.out.println("Hello World");

		// Login client1 = new Login();
		// AdminDashboard admin = new AdminDashboard();

		Server s1 = new Server(3000);
		try {
			s1.start();
			System.out.println("Started");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
