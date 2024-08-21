package com.library.BookstoreAPI.controller;


import com.library.BookstoreAPI.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // End point to create a new customer from JSON
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    // End point to register a new customer from form data
    @PostMapping("/register")
    public Customer registerCustomer(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {
        Customer customer = new Customer(customers.size() + 1, name, email, password);
        customers.add(customer);
        return customer;
    }

    // End point to retrieve all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // End point to retrieve a customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null); // Return null or throw an exception for not found
    }
}
