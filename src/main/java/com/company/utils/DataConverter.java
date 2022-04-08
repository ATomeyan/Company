package com.company.utils;

import com.company.model.AttendanceRecord;
import com.company.model.Department;
import com.company.model.Employee;
import com.company.model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConverter {

    private DataConverter() {
    }

    public static Department resultSetToDepartment(ResultSet resultSet) throws SQLException {

        Department department = new Department();

        department.setId(resultSet.getInt("Id"));
        department.setName(resultSet.getString("Name"));

        return department;
    }

    public static Position resultSetToPosition(ResultSet resultSet) throws SQLException {

        Position position = new Position();

        position.setId(resultSet.getInt("ID"));
        position.setName(resultSet.getString("Name"));

        return position;
    }

    public static Employee resultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setId(resultSet.getInt("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDateOfBirth(resultSet.getDate("date_of_birth"));
        employee.setEmail(resultSet.getString("email"));
        employee.setGender(resultSet.getString("gender"));
        employee.setPositionId(resultSet.getInt("position_id"));
        employee.setDepartmentId(resultSet.getInt("department_id"));

        return employee;
    }

    public static AttendanceRecord resultSetToAttendanceRecord(ResultSet resultSet) throws SQLException {

        AttendanceRecord attendanceRecord = new AttendanceRecord();

        attendanceRecord.setId(resultSet.getInt("Id"));
        attendanceRecord.setEntranceTime(resultSet.getTime("entrance_time"));
        attendanceRecord.setExitTime(resultSet.getTime("exit_time"));
        attendanceRecord.setEmployeeId(resultSet.getInt("employee_id"));

        return attendanceRecord;
    }
}