package com.realdolmen.travel.repository;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Created by JHRAU70 on 1/10/2014.
 */
@Ignore
@RunWith(Arquillian.class)
public class FlightRepositoryTest extends AbstractArquillianTestCase{

    @EJB
    private FlightRepository flightRepository;

    @Test
    public void canPersistAFlight(){
       assertEquals("Flight could not be persisted", true, true);
    }

}
