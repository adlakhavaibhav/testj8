package com.nm.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by adlakhavaibhav on 20/11/14.
 *
 */
public class NmStartupListener implements ServletContextListener {

    public NmStartupListener() {
    }

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("================  STARTING EDGE  ==================");


    }


    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("================  SHUTTING DOWN  ==================");
    }
}
