package com.company.repository;

import com.company.model.Position;
import com.company.utils.DataConverter;
import org.apache.commons.dbcp2.PoolingDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository {

    public List<Position> findAll(PoolingDataSource<Connection> dataSource) throws SQLException {

        List<Position> positions = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM position");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                positions.add(DataConverter.resultSetToPosition(resultSet));
            }
        }

        return positions;
    }
}