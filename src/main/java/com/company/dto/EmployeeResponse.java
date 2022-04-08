package com.company.dto;

import com.company.model.Employee;

import java.util.List;

public class EmployeeResponse extends SingleResponse{

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}