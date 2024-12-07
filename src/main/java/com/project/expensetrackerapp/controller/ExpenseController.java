package com.project.expensetrackerapp.controller;

import com.project.expensetrackerapp.model.Expense;
import com.project.expensetrackerapp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controller class for managing expense-related web requests.
 */
@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    /**
     * Handles the root URL ("/") and displays the home page with a list of expenses and the total amount.
     *
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Expense> expenses = expenseService.getAllExpenses();
        BigDecimal totalAmount = expenses.stream().map(Expense::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("expenses", expenses);
        model.addAttribute("totalAmount", totalAmount);
        return "index";
    }

    /**
     * Displays the page for adding a new expense.
     *
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping("/addExpense")
    public String showAddExpensePage(Model model) {
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "add-expense";
    }

    /**
     * Saves a new expense and redirects to the home page.
     *
     * @param expense the expense to save
     * @param model the model to add attributes to
     * @return the redirect URL
     */
    @PostMapping("/saveExpense")
    public String saveExpense(@ModelAttribute("expense") Expense expense, Model model) {
        expenseService.saveExpense(expense);
        return "redirect:/";
    }

    /**
     * Displays the page for editing an existing expense.
     *
     * @param id the ID of the expense to edit
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping("/editExpense/{id}")
    public String showUpdateExpensePage(@PathVariable("id") long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "update-expense";
    }

    /**
     * Updates an existing expense and redirects to the home page.
     *
     * @param id the ID of the expense to update
     * @param expense the updated expense
     * @param model the model to add attributes to
     * @return the redirect URL
     */
    @PostMapping("/updateExpense/{id}")
    public String updateExpense(@PathVariable("id") long id, @ModelAttribute("expense") Expense expense, Model model) {
        Expense existingExpense = expenseService.getExpenseById(id);
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());
        expenseService.saveExpense(existingExpense);
        return "redirect:/";
    }

    /**
     * Deletes an expense by its ID and redirects to the home page.
     *
     * @param id the ID of the expense to delete
     * @return the redirect URL
     */
    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable("id") long id) {
        expenseService.deleteExpenseById(id);
        return "redirect:/";
    }
}