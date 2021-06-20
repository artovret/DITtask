package com.example.task4;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Зашли в мейн ");
        SpringApplication.run(Application.class, args);
    }
}