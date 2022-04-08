package com.company.model;

import java.sql.Date;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String gender;
    private Boolean active;
    private int positionId;
    private int departmentId;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, Date dateOfBirth,
                    String email, String gender, Boolean active, int positionId, int departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
        this.active = active;
        this.positionId = positionId;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", date_of_birth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", active=" + active +
                ", positionId=" + positionId +
                ", departmentId=" + departmentId +
                '}';
    }
}