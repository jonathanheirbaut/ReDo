package com.realdolmen.travel.script;


import com.realdolmen.travel.repository.RegionRepository;
import com.realdolmen.travel.domain.Region;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DatabaseScript {

    @Inject
    RegionRepository dao;

    public DatabaseScript() {
    }

    public void createRegion(Region region){
        dao.create(region);
    }




}
