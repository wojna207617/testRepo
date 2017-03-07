package com.monitoring.logic;

import com.sun.org.apache.bcel.internal.util.ClassSet;

import java.util.ArrayList;

/**
 * Created by dawid.wojna on 31.10.2016.
 */
public class ErrorsRepository {

    private ArrayList<ErrorLogRecord> errors=new ArrayList<ErrorLogRecord>();
    private static ErrorsRepository ourInstance = null;

    private ErrorsRepository() {}

    public static ErrorsRepository getInstance() {
    	if(ourInstance == null) {
    		ourInstance = new ErrorsRepository();
         }
         return ourInstance;
    }

    public void addError(ErrorLogRecord error)
    {
        this.errors.add(error);
    }

    public ArrayList<ErrorLogRecord> getList() {
        return this.errors;
    }
}
