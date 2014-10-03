package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.RegionRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;
@Stateless
public class RegionService implements Serializable{

    private Collection<Region> regions;
    @Inject
    private RegionRepository regionRepository;

    public Collection<Region> findAll() {
        return regionRepository.findAll();
    }
}
