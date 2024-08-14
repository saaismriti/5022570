package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Derived query method to find employees by name
    List<Employee> findByName(String name);

    // Derived query method to find employees by department
    List<Employee> findByDepartmentName(String departmentName);
}
