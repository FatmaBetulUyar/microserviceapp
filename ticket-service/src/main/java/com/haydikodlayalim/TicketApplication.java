package com.haydikodlayalim;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class TicketApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketApplication.class, args);
    }
}