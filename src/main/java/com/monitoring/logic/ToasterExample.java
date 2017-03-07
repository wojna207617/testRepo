package com.monitoring.logic;

import com.nitido.utils.toaster.Toaster;

/**
 * Created by dawid.wojna on 28.10.2016.
 */


public class ToasterExample {

        public static void main(String[] args) {
                Toaster toasterManager = new Toaster();
                toasterManager.showToaster("JToaster Hello World!");
        }
}