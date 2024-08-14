package com.library.service;

import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.library.entity.Employee;
import com.library.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private static EmployeeRepository employeeRepository;

    @Autowired
    private SessionFactory sessionFactory;

    // Method to get paginated and sorted employees
    public static Page<Employee> getEmployees(int page, int size, String sortBy, String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.by(sortBy).with(Sort.Direction.fromString(sortOrder))));
        return employeeRepository.findAll(pageable);
    }

    // Method to perform batch insert of employees
    public void batchInsertEmployees(List<Employee> employees) {
        StatelessSession session = sessionFactory.openStatelessSession();
        Transaction tx = session.beginTransaction();

        try {
            for (int i = 0; i < employees.size(); i++) {
                session.insert(employees.get(i));
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
