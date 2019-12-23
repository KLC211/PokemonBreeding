package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) throws IOException {
		return args -> {
			Scanner input = new Scanner(System.in);
			ArrayList<String> groups=new ArrayList<>();
			groups=GetAndPost.GetGroups();
			System.out.println("Please select an egg group:");
			for (int i =0; i<groups.size(); i++){
				System.out.println(i+1+". "+groups.get(i));
			}

			int selection = input.nextInt();


			System.out.println(GetAndPost.MyGet(selection));


		};
	};

}
