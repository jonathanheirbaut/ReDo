package com.realdolmen.travel.repository;

import com.realdolmen.travel.builder.FlightBuilder;
import com.realdolmen.travel.common.AbstractArquillianTestCase;
import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Inject
    private LocationRepository locationRepository;
    @Inject
    private RegionRepository regionRepository;



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

    //TO DO: TEST DEFTIG UITWERKEN
    @Test
    public void canCalculateAveragePrice() {

        Location departure = locationRepository.find(2L);
        Location destination = locationRepository.find(5L);
        Region departureRegion = regionRepository.find(1L);
        Region destinationRegion = regionRepository.find(1L);


        System.out.println(departure.getName());
        System.out.println(destination.getName());
        System.out.println(departureRegion.getName());
        System.out.println(destinationRegion.getName());

        System.out.println("average = " + flightRepository.testCalculateAveragePrice(departure, destination, departureRegion, destinationRegion));

    }

}
