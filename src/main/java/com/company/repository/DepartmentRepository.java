package com.company.repository;

import com.company.model.Department;
import com.company.utils.DataConverter;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    public List<Department> findAll(PoolingDataSource<Connection> dataSource) throws SQLException {

        List<Department> departments = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM department");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                departments.add(DataConverter.resultSetToDepartment(resultSet));
            }
        }

        return departments;
    }
}