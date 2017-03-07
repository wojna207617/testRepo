package com.monitoring.databaseConnection;

/**
 * Created by dawid.wojna on 28.10.2016.
 */
public class ConnectionErrorException extends Exception {

    public ConnectionErrorException(String message)
    {
        super(message);
    }
}
