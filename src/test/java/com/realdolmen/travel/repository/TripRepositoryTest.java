package com.realdolmen.travel.repository;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by JHRAU70 on 10/10/2014.
 */
@RunWith(Arquillian.class)
public class TripRepositoryTest extends AbstractArquillianTestCase {
    @Inject
    private TripRepository tripRepository;
    @Inject
    private FlightRepository flightRepository;
    @Inject
    private LocationRepository locationRepository;



    @Test
    public void canCalculateTripPriceWith1PersonWithoutDiscount() throws Exception {
        BigDecimal priceOutboundFlight = new BigDecimal(10);
        BigDecimal priceReturnFlight = new BigDecimal(5);
        BigDecimal priceLocation = new BigDecimal(50);
        BigDecimal days = new BigDecimal(11);
        Integer numberOfPeople = 1;
        Flight outwardFlight = flightRepository.find(1L);
        Flight returnFlight = flightRepository.find(2L);
        Location location = locationRepository.find(1l);

        BigDecimal tripPrice = tripRepository.calculateTripPrice(location, outwardFlight, returnFlight, numberOfPeople);

        assertEquals("Price of a trip could not be calculated", new BigDecimal(1).multiply(priceLocation).multiply(days).add(priceOutboundFlight).add(priceReturnFlight), tripPrice);
    }

    @Test
    public void canCalculateTripPriceWith5PersonsWithDiscount() throws Exception {
        Integer numberOfPeople = 5;
        BigDecimal priceOutboundFlight = new BigDecimal(10*numberOfPeople*0.8);
        BigDecimal priceReturnFlight = new BigDecimal(5*numberOfPeople*0.8);
        BigDecimal priceLocation = new BigDecimal(50);
        BigDecimal days = new BigDecimal(11);
        Flight outwardFlight = flightRepository.find(1L);
        Flight returnFlight = flightRepository.find(2L);
        Location location = locationRepository.find(1l);

        BigDecimal tripPrice = tripRepository.calculateTripPrice(location, outwardFlight, returnFlight, numberOfPeople);

        assertEquals("Price of a trip could not be calculated", new BigDecimal(numberOfPeople).multiply(priceLocation).multiply(days).add(priceOutboundFlight).add(priceReturnFlight), tripPrice);
    }
}
