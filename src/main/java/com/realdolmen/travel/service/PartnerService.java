package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.repository.PartnerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class PartnerService {
    private Collection<Partner> partners;

    @Inject
    private PartnerRepository partnerRepository;

    public Collection<Partner> findAll() {
        return partnerRepository.findAll();
    }

}
