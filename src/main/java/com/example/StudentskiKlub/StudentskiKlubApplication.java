package com.example.StudentskiKlub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(
        scanBasePackages = {
                "com.example.StudentskiKlub",
                "controller",
                "data",
                "model"
        }
)

public class StudentskiKlubApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentskiKlubApplication.class, args);
	}

}
