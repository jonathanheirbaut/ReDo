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
import java.util.List;

@Named
@ViewScoped
public class LocationController {

    @Inject
    LocationService locationService;
    private List<Region> regions;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public Collection<Region> findAllRegions(){
        return locationService.findAllRegions();
    }

    public Collection<Location> findAllLocations(){
        return locationService.findAllLocations();
    }

    public Collection<Location> getLocationsByRegion(Region region){
        return locationService.getLocationsByRegion(region);
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
