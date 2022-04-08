package com.company.service;

import com.company.dbconfig.DataSourceFactory;
import com.company.dto.EmployeeResponse;
import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.repository.EmployeeRepository;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.SQLException;

public class EmployeeService {

    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    private EmployeeService() {
    }

    public static EmployeeResponse getAllEmployees() {

        PoolingDataSource dataSource = DataSourceFactory.getInstance();
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeResponse response = new EmployeeResponse();

        try {
            response.setEmployees(repository.findAll(dataSource));
            response.setSuccess(true);

        } catch (SQLException e) {
            LOGGER.error("Failed to get Employee data: " + e.getMessage());
            response.setSuccess(false);
            response.setErrorMessage("Failed to get Employee data. Call administration");
        }

        return response;
    }
}