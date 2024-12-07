package com.project.expensetrackerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * Main class for the Expense Tracker application.
 * This is the entry point of the Spring Boot application.
 */
@SpringBootApplication
public class ExpenseTrackerApplication {

    /**
     * Main method which starts the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ExpenseTrackerApplication.class);
        if (System.getenv("PORT") != null) {
            app.setDefaultProperties(Collections.singletonMap("server.port", System.getenv("PORT")));
        }
        app.run(args);
    }
}