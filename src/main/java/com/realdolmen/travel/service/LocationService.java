package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.LocationRepository;
import com.realdolmen.travel.repository.RegionRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by KVEAU50 on 7/10/2014.
 */
@Stateless
public class LocationService {
    private Collection<Location> locations;

    @Inject
    LocationRepository locationRepository;
    @Inject
    RegionRepository regionRepository;

    public Collection<Location> findAllLocations() {
        return locationRepository.findAll();
    }
    public Collection<Region> findAllRegions() {
        return regionRepository.findAll();
    }


    public Collection<Location> getLocationsByRegion(Region region) {
        return locationRepository.getLocationsByRegion(region);
    }
}
