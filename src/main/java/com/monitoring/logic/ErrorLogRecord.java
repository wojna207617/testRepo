package com.monitoring.logic;

import java.util.Date;

/**
 * Created by dawid.wojna on 31.10.2016.
 */
public class ErrorLogRecord {

    private String jobid; //int
    private String datum; //date
    private String counter; //int
    private String programmname;
    private String funktion;
    private String userId;
    private String parameter;
    private String fehlertext;
    private String checkedOn; //date
    private String database;

    public ErrorLogRecord(String jobid, String datum, String counter, String programmname, String funktion, String userId, 
    		String parameter, String fehlertext, String checkedOn, String database)
    {
        this.jobid=jobid;
        this.datum=datum;
        this.counter=counter;
        this.programmname=programmname;
        this.funktion=funktion;
        this.userId=userId;
        this.parameter=parameter;
        this.fehlertext=fehlertext;
        this.checkedOn=checkedOn;
        this.database=database;
    }

    public String toString()
    {
        return this.jobid+" | " + this.datum + " | "+ this.counter + " | "+this.programmname+ " | "+this.funktion+" | "+this.userId+
        		" | "+this.parameter+" | "+this.fehlertext+" | "+this.checkedOn+" | "+this.database;
    }
}
