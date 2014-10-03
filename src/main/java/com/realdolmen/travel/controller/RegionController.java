package com.realdolmen.travel.controller;

import com.mysql.jdbc.log.LogFactory;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.service.FlightService;
import com.realdolmen.travel.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    protected Logger logger = LoggerFactory.getLogger(getClass());
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

    public void doSomeThing(){
        System.out.println("test");
        logger.info("blabla");
    }

}
