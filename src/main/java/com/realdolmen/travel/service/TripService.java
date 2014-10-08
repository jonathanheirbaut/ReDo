package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.repository.TripRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Stateless
public class TripService {
    @Inject
    private TripRepository tripRepository;

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }
}
