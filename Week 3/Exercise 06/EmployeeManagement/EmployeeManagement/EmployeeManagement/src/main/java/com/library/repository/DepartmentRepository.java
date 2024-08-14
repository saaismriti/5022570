package com.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
	 	@Query("SELECT d FROM Department d WHERE d.name = :name")
	    Department findByName(@Param("name") String name);

	    // Custom query to find all departments with a specific employee count
	    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) = :count")
	    List<Department> findByEmployeeCount(@Param("count") int count);

	    // Custom query to find departments by partial name match using LIKE
	    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
	    List<Department> findByNameContaining(@Param("name") String name);

	    // Custom query to find departments where the department name starts with a specific prefix
	    @Query("SELECT d FROM Department d WHERE d.name LIKE :prefix%")
	    List<Department> findByNameStartingWith(@Param("prefix") String prefix);

	    // Custom native query to get all departments ordered by name
	    @Query(value = "SELECT * FROM departments ORDER BY name", nativeQuery = true)
	    List<Department> findAllOrderedByName();
	    
	 
	    Page<Department> findAll(Pageable pageable);
	    
	    
	    	        // Method to find departments by name containing a specific string with pagination
	        Page<Department> findByNameContaining(String name, Pageable pageable);

	    
	    
}
