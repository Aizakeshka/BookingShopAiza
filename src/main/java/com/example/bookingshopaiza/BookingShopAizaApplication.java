package com.example.bookingshopaiza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.bookingshopaiza.entity")
public class BookingShopAizaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingShopAizaApplication.class, args);
	}

}
