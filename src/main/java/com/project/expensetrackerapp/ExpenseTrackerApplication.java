package com.project.expensetrackerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}
}