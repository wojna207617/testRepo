package com.monitoring.databaseConnection;

import java.sql.*;

import static oracle.jdbc.OracleTypes.VARCHAR;

/**
 * Created by dawid.wojna on 28.10.2016.
 */
public class ConnectionToOracle {

    private String URL="";
    private String User="";
    private String Password="";
    private Connection conn= null;

    public ConnectionToOracle(String dbUrl, String dbUser, String dbPass)
    {
        this.URL=dbUrl;
        this.User=dbUser;
        this.Password=dbPass;
    }

    public void startConnection() throws ConnectionErrorException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new ConnectionErrorException("Driver to database missing.");
        }

        try {
            this.conn=DriverManager.getConnection(this.URL, this.User, this.Password);
        } catch (SQLException e) {
            throw new ConnectionErrorException("Connection error.");
        }
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }


    public String executeAnonBlock(String block) throws SQLException
    {
        CallableStatement cs = this.conn.prepareCall(block);
        cs.registerOutParameter(1, VARCHAR);
        cs.executeUpdate();
        String result = cs.getString(1);
        return result;
    }
}