package com.company.dbconfig;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class DataSourceFactory {

    private static PoolingDataSource dataSource = null;
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            ClassLoader classLoader = DataSourceFactory.class.getClassLoader();
            final InputStream inputStream = classLoader.getResourceAsStream("database.properties");
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String URL = PROPERTIES.getProperty("db.url");
    private static final String USER = PROPERTIES.getProperty("db.user");
    private static final String PASS = PROPERTIES.getProperty("db.password");
    private static final String CLASS_NAME = PROPERTIES.getProperty("db.classname");


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