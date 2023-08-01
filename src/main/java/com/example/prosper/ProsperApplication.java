package com.example.prosper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController                                                      
public class ProsperApplication { 

	public static void main(String[] args) {
		SpringApplication.run(ProsperApplication.class, args);
	}
    

} 
