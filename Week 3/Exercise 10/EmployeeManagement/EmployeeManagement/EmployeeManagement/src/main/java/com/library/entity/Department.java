package com.library.entity;

import java.util.List;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "departments")
@NamedQueries({
    // Named query to find a department by name
    @NamedQuery(name = "Department.findByName", 
                query = "SELECT d FROM Department d WHERE d.name = :name"),

    // Named query to find all departments with a specific employee count
    @NamedQuery(name = "Department.findByEmployeeCount", 
                query = "SELECT d FROM Department d WHERE SIZE(d.employees) = :count"),

    // Named query to find departments by partial name match using LIKE
    @NamedQuery(name = "Department.findByNameContaining", 
                query = "SELECT d FROM Department d WHERE d.name LIKE :name"),

    // Named query to find departments ordered by name
    @NamedQuery(name = "Department.findAllOrderedByName", 
                query = "SELECT d FROM Department d ORDER BY d.name ASC")
})
@EntityListeners(AuditingEntityListener.class)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @BatchSize(size = 10) 
    private List<Employee> employees;
    
    
    
    
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

    

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

