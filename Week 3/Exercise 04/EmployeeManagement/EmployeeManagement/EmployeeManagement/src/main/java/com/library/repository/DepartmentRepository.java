package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Derived query method to find a department by name
    Department findByName(String name);
}
