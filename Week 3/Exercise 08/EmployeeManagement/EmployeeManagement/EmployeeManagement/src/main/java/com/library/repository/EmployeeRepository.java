package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.library.dto.EmployeeDTO;
import com.library.entity.Employee;
import com.library.projection.EmployeeNameEmailProjection;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	Page<Employee> findAll(Pageable pageable);
	

    List<Employee> findAll(Sort sort);
	
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
    

    @Query("SELECT e.name as name, e.email as email FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeNameEmailProjection> findByDepartmentId(@Param("departmentId") Long departmentId);

    @Query("SELECT new com.library.dto.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDTO> findEmployeeDTOByDepartmentId(@Param("departmentId") Long departmentId);

    
}
    
    