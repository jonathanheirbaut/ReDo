package com.realdolmen.travel.repository;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by JHRAU70 on 1/10/2014.
 */
@RunWith(Arquillian.class)
public class FlightRepositoryTest extends AbstractArquillianTestCase{

    @Inject
    private FlightRepository flightRepository;

    public void canPersistAFlight(){
        //flightRepository.
    }

}
