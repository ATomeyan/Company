package com.company.repository;

import com.company.model.AttendanceRecord;
import com.company.utils.DataConverter;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRecordRepository {

    public List<AttendanceRecord> findAll(PoolingDataSource<Connection> dataSource) throws SQLException {

        List<AttendanceRecord> attendanceRecords = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM attendance_record");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                attendanceRecords.add(DataConverter.resultSetToAttendanceRecord(resultSet));
            }
        }

        return attendanceRecords;
    }
}