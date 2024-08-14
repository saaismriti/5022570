package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.library.entity.Employee;
import com.library.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private static EmployeeRepository employeeRepository;

    public static Page<Employee> getEmployees(int page, int size, String sortBy, String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.by(sortBy).with(Sort.Direction.fromString(sortOrder))));
        return employeeRepository.findAll(pageable);
    }
}
