package com.library.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String departmentNameWithEmployeeCount;

    public DepartmentDTO(Long id, String name, List<String> employees) {
        this.id = id;
        this.name = name;
        this.departmentNameWithEmployeeCount = name + " (Employees: " + employees.size() + ")";
    }


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

    public String getDepartmentNameWithEmployeeCount() {
        return departmentNameWithEmployeeCount;
    }

    public void setDepartmentNameWithEmployeeCount(String departmentNameWithEmployeeCount) {
        this.departmentNameWithEmployeeCount = departmentNameWithEmployeeCount;
    }
}
