package com.example.studentmarks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the Student Marks Calculator app.
 * Run this class (or `mvn spring-boot:run`) to start the server on http://localhost:8080
 */
@SpringBootApplication
public class StudentMarksApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMarksApplication.class, args);
    }
}
