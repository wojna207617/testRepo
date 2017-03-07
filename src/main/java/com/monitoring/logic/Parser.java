package com.monitoring.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dawid.wojna on 31.10.2016.
 */
public class Parser {

    private static String columnDelimiter="<next>";
    private static String newLineDelimiter="<eol>";
    private String database;
    private ArrayList<ErrorLogRecord> result=new ArrayList<ErrorLogRecord>();

    public Parser(String database)
    {
        this.database=database;
    }

    public ArrayList<ErrorLogRecord> parse(String toParse){


        List<String> recordsFromLog=new ArrayList<String>();
        int tmpResultLength=0;
        for(int i=0; i<toParse.length(); i++)
        {
        	recordsFromLog=Arrays.asList(toParse.split("<eol>"));
        }
        
        tmpResultLength=0;
        String midwayParsed="";
        List<String> midList=new ArrayList<String>();

        for(int i=0; i<recordsFromLog.size(); i++)
        {
            midwayParsed=recordsFromLog.get(i);
            midList=Arrays.asList(midwayParsed.split("<next>"));
            
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Calendar calobj = Calendar.getInstance();
            
            result.add(new ErrorLogRecord(midList.get(0),
                    midList.get(1),	midList.get(2),
                    midList.get(3),	midList.get(4),
                    midList.get(5),	midList.get(6),
                    midList.get(7),
                    df.format(calobj.getTime()),
                    this.database));
        }

        for(ErrorLogRecord s : result){ //TODO
              System.out.println(s.toString());
        }

        return result;
    }
}
