package com.company.service;

import com.company.dbconfig.DataSourceFactory;
import com.company.dto.PositionResponse;
import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.repository.PositionRepository;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.SQLException;

public class PositionService {

    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    private PositionService(){
    }

    public static PositionResponse getAllPositions() {

        PoolingDataSource dataSource = DataSourceFactory.getInstance();
        PositionRepository repository = new PositionRepository();
        PositionResponse response = new PositionResponse();

        try {
            response.setPositions(repository.findAll(dataSource));
            response.setSuccess(true);

        } catch (SQLException e) {
            LOGGER.error("Failed to get Position data: " + e.getMessage());
            response.setSuccess(false);
            response.setErrorMessage("Failed to get Position data. Call administration");
        }

        return response;
    }
}