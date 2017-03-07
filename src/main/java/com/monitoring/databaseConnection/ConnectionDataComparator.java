package com.monitoring.databaseConnection;

import java.util.Comparator;

/**
 * Created by dawid.wojna on 28.10.2016.
 */
public class ConnectionDataComparator implements Comparator<ConnectionData> {

    public int compare(ConnectionData connectionData, ConnectionData t1) {
        return connectionData.compareTo(t1);
    }
}
