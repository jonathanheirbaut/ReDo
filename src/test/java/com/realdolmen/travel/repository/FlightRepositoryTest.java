package com.realdolmen.travel.repository;

import com.realdolmen.travel.builder.FlightBuilder;
import com.realdolmen.travel.common.AbstractArquillianTestCase;
import com.realdolmen.travel.domain.Flight;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.transaction.*;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by JHRAU70 on 1/10/2014.
 */
@RunWith(Arquillian.class)
public class FlightRepositoryTest extends AbstractArquillianTestCase {

    @Inject
    private FlightRepository flightRepository;


    @Resource
    private UserTransaction tx;

    @Before
    public void init() throws SystemException, NotSupportedException {
        tx.begin();
    }

    @After
    public void destroy() throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {
        tx.rollback();
    }

    @Test
    public void canPersistAFlight() {
        Flight flight = FlightBuilder.flight().withDepartureDate(new Date()).withPrice(100.0).build();
        flightRepository.create(flight);
        assertNotNull("Flight could not be persisted", flight.getId());
    }

    @Test
    public void canUpdateAFlight() {
        Flight flight = FlightBuilder.flight().withDepartureDate(new Date()).withPrice(0.0).build();
        flightRepository.create(flight);
        flight.setPrice(250.0);
        flightRepository.update(flight);
        assertEquals("Flight could not be updated", new Double(250.0), flight.getPrice());
    }
    @Test
    public void canCalculateAveragePrice() {
        flightRepository.calculateAveragePrice();
    }
}
