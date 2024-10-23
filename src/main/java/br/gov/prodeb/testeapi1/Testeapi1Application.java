package br.gov.prodeb.testeapi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Testeapi1Application {

	public static void main(String[] args) {
		SpringApplication.run(Testeapi1Application.class, args);
	}

}
