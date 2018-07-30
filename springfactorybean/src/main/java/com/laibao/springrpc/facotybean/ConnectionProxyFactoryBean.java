package com.laibao.springrpc.facotybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
public class ConnectionProxyFactoryBean implements FactoryBean<Connection>,InitializingBean{

    private String jdbcDriver;

    private String connectionUrl;

    private String dbUserName;

    private String dbPassword;

    private Connection connection;

    public Connection getObject() throws Exception {
        return connection;
    }

    public Class<?> getObjectType() {
        return Connection.class;
    }

    public void afterPropertiesSet() throws Exception {
         /* Register jdbc driver class. */
        Class.forName(jdbcDriver);
		/* Get the jdbc Connection object. */
        connection = DriverManager.getConnection(connectionUrl, dbUserName, dbPassword);
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}
