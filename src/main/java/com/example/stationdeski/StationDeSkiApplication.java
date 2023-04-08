package com.example.stationdeski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StationDeSkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StationDeSkiApplication.class, args);
    }

}
