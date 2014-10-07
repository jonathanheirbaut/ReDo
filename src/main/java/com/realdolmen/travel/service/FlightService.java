package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.FlightRepository;
import com.realdolmen.travel.repository.PartnerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Stateless
public class FlightService {
    private Collection<Flight> flights;

    @Inject
    private FlightRepository flightRepository;
    @Inject
    private PartnerRepository partnerRepository;


    public Double calculateMinimumPrice(Region departureRegion, Region destinationRegion, Date startDate, Date endDate, Partner partner) {
        return flightRepository.calculateMinimumPrice(departureRegion, destinationRegion, startDate, endDate, partner);
    }

    public Double calculateMaximumPrice(Region departureRegion, Region destinationRegion, Date startDate, Date endDate, Partner partner) {
        return flightRepository.calculateMaximumPrice(departureRegion, destinationRegion, startDate, endDate, partner);
    }

    public Collection<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Double calculateAveragePrice(Region departureRegion, Region destinationRegion, Date startDate, Date endDate, Partner partner) {
        return flightRepository.calculateAveragePrice(departureRegion, destinationRegion, startDate, endDate, partner);
    }

    public List<Flight> findAllByPartner(Partner partner) { return flightRepository.findAllByPartner(partner);

    }
    public Collection<Partner> findAllPartners() {
        return partnerRepository.findAll();
    }


    public void create(Flight flight) {
        flightRepository.create(flight);
    }


}


