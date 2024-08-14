package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Employee;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by name
    List<Employee> findByName(String name);

    // Find employees by email
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmailUsingJPQL(@Param("email") String email);

    // Custom query to find employees by department name using JPQL
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findByDepartmentNameUsingJPQL(@Param("departmentName") String departmentName);

    // Custom query to find employees with a specific name and department using JPQL
    @Query("SELECT e FROM Employee e WHERE e.name = :name AND e.department.name = :departmentName")
    List<Employee> findByNameAndDepartment(@Param("name") String name, @Param("departmentName") String departmentName);
}



