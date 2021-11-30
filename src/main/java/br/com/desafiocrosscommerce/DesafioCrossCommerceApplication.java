package br.com.desafiocrosscommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioCrossCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCrossCommerceApplication.class, args);
	}

}
