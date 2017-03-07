package com.monitoring.databaseConnection;

/**
 * Created by dawid.wojna on 28.10.2016.
 */
public class ConnectionData {

    private String url = "";
    private String user = "";
    private String password = "";
    private String humanReadableName = "";

    public ConnectionData(String database, String user, String password)
    {
        this.user=user;
        this.password=password;
        humanReadableName=database;
        if(database.compareToIgnoreCase("DEV")==0)
        {
            this.url="fakelink";
        }
        else if(database.endsWith("V"))
        {
            this.url="fakelink"+database;
        }
        else this.url="fakelink"+database;
    }

    public String getUrl()
    {
        return this.url;
    }

    public String getUser()
    {
        return this.user;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getHumanReadableName()
    {
        return this.humanReadableName;
    }

    public int compareTo(ConnectionData cd)
    {
        if(cd.getHumanReadableName().compareToIgnoreCase(this.getHumanReadableName())>0)
            return -1;
        else if(cd.getHumanReadableName().compareToIgnoreCase(this.getHumanReadableName())<0)
            return 1;
        else
            return cd.getHumanReadableName().compareToIgnoreCase(this.getHumanReadableName());
    }
}
