package com.company.service;

import com.company.dbconfig.DataSourceFactory;
import com.company.dto.DepartmentResponse;
import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.repository.DepartmentRepository;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.SQLException;

public class DepartmentService {

    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    private DepartmentService() {
    }

    public static DepartmentResponse getAllDepartments() {

        PoolingDataSource poolingDataSource = DataSourceFactory.getInstance();
        DepartmentRepository repository = new DepartmentRepository();
        DepartmentResponse response = new DepartmentResponse();

        try {
            response.setDepartments(repository.findAll(poolingDataSource));
            response.setSuccess(true);

        } catch (SQLException sqlException) {
            LOGGER.error("Failed to get Department data: " + sqlException.getMessage());
            response.setSuccess(false);
            response.setErrorMessage("Failed to get Department data. Call administration.");
        }

        return response;
    }
}