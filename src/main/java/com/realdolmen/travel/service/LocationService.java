package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.repository.LocationRepository;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by KVEAU50 on 7/10/2014.
 */
public class LocationService {
    private Collection<Location> locations;

    @Inject
    LocationRepository locationRepository;

    public Collection<Location> findAll() {
        return locationRepository.findAll();
    }

}
