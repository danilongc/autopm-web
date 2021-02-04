package br.com.dnc.pmcheatweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PmcheatWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(PmcheatWebApplication.class, args);
	}

}
