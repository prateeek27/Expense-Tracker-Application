package com.project.expensetrackerapp.service;

import com.project.expensetrackerapp.model.Expense;
import com.project.expensetrackerapp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing expenses.
 */
@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * Retrieves all expenses from the repository.
     *
     * @return a list of all expenses
     */
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    /**
     * Saves a given expense to the repository.
     *
     * @param expense the expense to save
     */
    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    /**
     * Retrieves an expense by its ID.
     *
     * @param id the ID of the expense to retrieve
     * @return the expense with the given ID, or null if not found
     */
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    /**
     * Deletes an expense by its ID.
     *
     * @param id the ID of the expense to delete
     */
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }
}