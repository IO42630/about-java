package com.olexyn.about.java.design.architectures.microservice;


import java.util.Map;

public class MicroService {

    private Map<String,String> data;

    public void addData(String dataString) {
        var payload = dataString.split(":");
        data.put(payload[0], payload[1]);
    }

    public String getData() {
        return data.toString();
    }

    /**
     * TODO should communicate via IPC.
     */
    public static void main(String... args){
        var microA = new MicroService();
        var microB = new MicroService();
        //
    }
}

