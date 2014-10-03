package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.service.FlightService;
import com.realdolmen.travel.service.RegionService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class RegionController {
    @Inject
    RegionService regionService;

    private Region region;
    private Collection<Region> regions;

    @PostConstruct
    public void initialize() {
        regions = regionService.findAll();
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }
    public Collection<Region> getRegions() {
        return regions;
    }

}
