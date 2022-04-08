package com.company.dto;

import com.company.model.Department;

import java.util.List;

public class DepartmentResponse extends SingleResponse {

    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}