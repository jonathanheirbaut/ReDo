package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.service.LocationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@Named
@ViewScoped
public class LocationController {

    @Inject
    LocationService locationService;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private String test;
    private Collection<Region> regions;
    private Collection<Location> locations;

    @PostConstruct
    public void initialize() {
        regions = locationService.findAllRegions();
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    public Collection<Region> getRegions() {
        return regions;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Collection<Location> findAllLocations(){
        return locationService.findAllLocations();

    }
}
