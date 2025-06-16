package com.example.bscs_3b_group_opina;

import com.example.bscs_3b_group_opina.server.Views.AdminDashboard;
import com.example.bscs_3b_group_opina.server.Views.Login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Bscs3bGroupOpinaApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(Bscs3bGroupOpinaApplication.class)
				.headless(false)
				.run(args);

		System.out.println("Hello World");

		Login client1 = new Login();
		AdminDashboard admin = new AdminDashboard();

		client1.show();

	}

}
