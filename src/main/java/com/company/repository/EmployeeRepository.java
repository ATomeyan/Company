package com.company.repository;

import com.company.model.Employee;
import com.company.utils.DataConverter;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public List<Employee> findAll(PoolingDataSource<Connection> dataSource) throws SQLException {

        List<Employee> employees = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
             ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){
                employees.add(DataConverter.resultSetToEmployee(resultSet));
            }
        }
        return employees;
    }
}