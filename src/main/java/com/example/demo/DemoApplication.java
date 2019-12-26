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


			boolean stats[]=new boolean[6];
			System.out.println("Enter mother's (or father's if breeding with ditto) perfect IVs one by one (True or False):");
			for(int i=0; i<6; i++){
				stats[i]=input.nextBoolean();
			}
			System.out.println("Does it have a hidden ability (1 or 0)");
			boolean HA = input.nextBoolean();
			IndPokemon mother=new IndPokemon();
			mother.setAll(stats, HA);

			System.out.println("Enter father's (or Ditto's) perfect IVs one by one (1 or 0):");
			for(int i=0; i<6; i++){
				stats[i]=input.nextBoolean();
			}
			System.out.println("Does it have a hidden ability (1 or 0)");
			HA = input.nextBoolean();
			IndPokemon father=new IndPokemon();
			father.setAll(stats, HA);

			System.out.println("Are you using a destiny knot? (1 or 0");
			boolean destKnot=input.nextBoolean();

			float[] eggProbs=new float[7];
			eggProbs=IVProb.IVPerm(mother, father);

			if (destKnot==true){
				Eggs.destKnotProbs(eggProbs);
			}
			else{
				Eggs.noKnotProbs(eggProbs);
			}
		};
	};

}
