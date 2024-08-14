package com.library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.library.entity.Department;
import com.library.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	
	@Autowired
    private DepartmentRepository departmentRepository;

    public Page<Department> getDepartments(int page, int size, String sortBy, String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.by(sortBy).with(Sort.Direction.fromString(sortOrder))));
        return departmentRepository.findAll(pageable);
    }

    public Page<Department> getDepartmentsByNameContaining(String name, int page, int size, String sortBy, String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.by(sortBy).with(Sort.Direction.fromString(sortOrder))));
        return departmentRepository.findByNameContaining(name, pageable);
    }
}
