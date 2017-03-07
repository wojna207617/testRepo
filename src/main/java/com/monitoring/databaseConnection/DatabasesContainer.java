package com.monitoring.databaseConnection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by dawid.wojna on 28.10.2016.
 */
public class DatabasesContainer {

    private HashMap<String, ConnectionData> connectionData = new HashMap<String, ConnectionData>();

    public DatabasesContainer()
    {
        String user = "test";
        String password = "pass";

        this.connectionData.put("DEV", new ConnectionData("DEV", user, password));

    }

    public ArrayList<ConnectionData> listOfConnections()
    {
        ArrayList<ConnectionData> result = new ArrayList<ConnectionData>();
        for(ConnectionData cd : this.connectionData.values())
        {
            result.add(cd);
        }
        Collections.sort(result, new ConnectionDataComparator());
        return result;
    }

    public ConnectionData findConnection(String database)
    {
        return this.connectionData.get(database);
    }
}
