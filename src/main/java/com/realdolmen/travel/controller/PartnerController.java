package com.realdolmen.travel.controller;

import com.mysql.jdbc.log.LogFactory;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.service.FlightService;
import com.realdolmen.travel.service.PartnerService;
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
public class PartnerController {
    @Inject
    PartnerService partnerService;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private Collection<Partner> partners;

    @PostConstruct
    public void initialize() {
        partners = partnerService.findAll();
    }

    public Collection<Partner> getPartners() {
        return partners;
    }

    public void setPartners(Collection<Partner> partners) {
        this.partners = partners;
    }
}
