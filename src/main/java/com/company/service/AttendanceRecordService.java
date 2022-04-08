package com.company.service;

import com.company.dbconfig.DataSourceFactory;
import com.company.dto.AttendanceRecordResponse;
import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.repository.AttendanceRecordRepository;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.SQLException;

public class AttendanceRecordService {

    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    private AttendanceRecordService() {
    }

    public static AttendanceRecordResponse getAllAttendanceRecords() {
        PoolingDataSource poolingDataSource = DataSourceFactory.getInstance();
        AttendanceRecordRepository repository = new AttendanceRecordRepository();
        AttendanceRecordResponse response = new AttendanceRecordResponse();

        try {
            response.setAttendanceRecords(repository.findAll(poolingDataSource));
            response.setSuccess(true);

        } catch (SQLException e) {
            LOGGER.error("Failed to get Attendance Record data: " + e.getMessage());
            response.setSuccess(false);
            response.setErrorMessage("Failed to get Attendance Record data. Call administration.");
        }

        return response;
    }
}