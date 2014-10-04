package com.realdolmen.travel.controller;

import com.mysql.jdbc.log.LogFactory;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.service.FlightService;
import com.realdolmen.travel.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@SessionScoped
public class RegionController implements Serializable {
    @Inject
    RegionService regionService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
//    private Region departureRegion;
//    private Region locationRegion;
    private String test;
    private Collection<Region> regions;

    @PostConstruct
    public void initialize() {
        regions = regionService.findAll();
    }

//    public Region getDepartureRegion() {
//        return departureRegion;
//    }
//
//    public void setDepartureRegion(Region departureRegion) {
//        this.departureRegion = departureRegion;
//    }
//
//    public Region getLocationRegion() {
//        return locationRegion;
//    }
//
//    public void setLocationRegion(Region locationRegion) {
//        this.locationRegion = locationRegion;
//    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    public Collection<Region> getRegions() {
        return regions;
    }

    public void doSomeThing() {
     //   logger.info("I'm doing something, the name of the region is " + getDepartureRegion().getName());
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
