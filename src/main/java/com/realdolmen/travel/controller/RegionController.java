package com.realdolmen.travel.controller;

import com.mysql.jdbc.log.LogFactory;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.service.FlightService;
import com.realdolmen.travel.service.LocationService;
import com.realdolmen.travel.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class RegionController {
    @Inject
    RegionService regionService;

    @Inject
    LocationService locationService;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private String test;
    private Collection<Region> regions;
    private Collection<Location> locations;

    @PostConstruct
    public void initialize() {
        regions = regionService.findAll();
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

    public Collection<Location> findAll(){
        return locationService.findAll();

    }
}
