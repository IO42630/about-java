package com.olexyn.about.java.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Examples {

    public static void main(String[] args) throws Exception {
        Server server = new Server();

        ServerConnector connector0 = new ServerConnector(server);
        connector0.setPort(8896);

        ServerConnector connector1 = new ServerConnector(server);
        connector1.setHost("127.0.0.1");
        connector1.setPort(8897);
        connector1.setName("admin");


        server.setConnectors(new Connector[]{connector0,
                                             connector1});

        server.setHandler(new ServletContextHandler());

        server.start();
        server.join();
    }
}
