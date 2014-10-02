package com.realdolmen.travel.script;


public class Runner {

    public static void main(String[] args) {

        ScriptService scriptService= new ScriptService();
        scriptService.createRandomFlights(10000);

    }

}
