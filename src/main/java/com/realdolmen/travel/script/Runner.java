package com.realdolmen.travel.script;


import com.realdolmen.travel.domain.Flight;


public class Runner {

    public static void main(String[] args) {

        ScriptService scriptService= new ScriptService();
        scriptService.createFlight(new Flight());

    }




}
