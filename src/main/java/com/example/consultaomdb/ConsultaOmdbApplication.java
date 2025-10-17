package com.example.consultaomdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsultaOmdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultaOmdbApplication.class, args);
    }

}
