package com.company.dbconfig;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public final class DataSourceFactory {

    private static PoolingDataSource dataSource = null;

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private DataSourceFactory() {
    }

    public static PoolingDataSource getInstance() {

        if (dataSource == null) {
            try {
                Class.forName(CLASS_NAME).newInstance();
                dataSource = poolingDataSource();

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    private static PoolingDataSource poolingDataSource() {

        GenericObjectPoolConfig<PoolableConnection> genericObjectPool = new GenericObjectPoolConfig<>();

        genericObjectPool.setMaxIdle(10);
        genericObjectPool.setMinIdle(5);

        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(DataSourceFactory.URL,
                DataSourceFactory.USER, DataSourceFactory.PASS);

        PoolableConnectionFactory pooledObjectFactory = new PoolableConnectionFactory(connectionFactory, null);

        ObjectPool connectionPool = new GenericObjectPool(pooledObjectFactory, genericObjectPool);

        return new PoolingDataSource(connectionPool);
    }
}