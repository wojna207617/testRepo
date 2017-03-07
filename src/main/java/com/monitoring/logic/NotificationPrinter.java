package com.monitoring.logic;


import javax.swing.*;

import com.nitido.utils.toaster.Toaster;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created by dawid.wojna on 28.10.2016.
 */
public class NotificationPrinter extends TimerTask{

    private String message="";

    public void setMessage(String message)
    {
        this.message=message;
    }

    public void run() {
        Toaster toasterManager = new Toaster();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        toasterManager.setToasterHeight(250);
        toasterManager.setMessageColor(Color.RED);
        toasterManager.setDisplayTime(10000);
        toasterManager.setBorderColor(Color.RED);
        toasterManager.setToasterWidth(500);


        toasterManager.showToaster(sdf.format(cal.getTime())+" "+message);
        //System.out.println(sdf.format(cal.getTime())+" "+message); TO DO

    }
}
