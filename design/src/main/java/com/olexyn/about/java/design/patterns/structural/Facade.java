package com.olexyn.about.java.design.patterns.structural;

/*
 * Facade (=Fassade).
 * A higher-level interface providing simpler access to a set of sub-interfaces.
 */

interface ComputerFacade{


    CPU cpu = new CPUImpl();

    MB mb = new MBImpl();

    RAM ram = new RAMImpl();
}




interface CPU{}

interface MB{}

interface RAM{}



class CPUImpl implements CPU{

}

class MBImpl implements MB{}

class RAMImpl implements  RAM{}



