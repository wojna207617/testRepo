package com.monitoring.logic;

import com.monitoring.databaseConnection.ConnectionErrorException;
import com.monitoring.databaseConnection.ConnectionToOracle;
import com.monitoring.databaseConnection.DatabasesContainer;
import com.monitoring.view.MainWindow;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by dawid.wojna on 28.10.2016.
 */
public class Main {

    //na startupie żeby wczytywało błędy też z ostatnich 24h wydaje mi się


    public static void main(String[] args) {

        String message="";
        NotificationPrinter notificator=new NotificationPrinter();
        Timer timer = new Timer();
        DatabasesContainer dbContainer = new DatabasesContainer();
        ErrorlogQuery query=new ErrorlogQuery();

        //while(true){
            ConnectionToOracle conn=new ConnectionToOracle(dbContainer.findConnection("DEV").getUrl(),
                    dbContainer.findConnection("DEV").getUser(),
                    dbContainer.findConnection("DEV").getPassword());

            try {
                conn.startConnection();
            } catch (ConnectionErrorException e) {
                notificator.
                        setMessage(e.getMessage());
            }

            try {

                message=conn.
                        executeAnonBlock(query.
                                getQuery());
                notificator.setMessage(message);
            } catch (SQLException e) {
                notificator.
                        setMessage(e.getMessage());
            }

        ErrorsRepository repository=ErrorsRepository.getInstance();
        Parser parser=new Parser("DEV");
        ArrayList<ErrorLogRecord> results=parser.parse(message);
        
        for(ErrorLogRecord r : results)
        {
        	repository.addError(r);
        }
        
        MainWindow application=new MainWindow();


        timer.schedule(notificator, 0, 10*1000); //trzeba chyba przenieść całą tą logikę do notyfikatora żeby to ona była schedulowana co to 5 minut czy ileś i wtedy nie na inf. while'u
        //}

        try {
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
