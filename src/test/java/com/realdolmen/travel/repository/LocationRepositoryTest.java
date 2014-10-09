package com.realdolmen.travel.repository;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
import com.realdolmen.travel.domain.Location;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@RunWith(Arquillian.class)
public class LocationRepositoryTest extends AbstractArquillianTestCase {
    @Inject
    private LocationRepository locationRepository;
    @Inject
    private RegionRepository regionRepository;

    @Test
    public void canGetAllLocationsByRegion() throws Exception {
        Collection<Location> locationsByRegion = locationRepository.getLocationsByRegion(regionRepository.find(1L));
        assertEquals("Locations by region were not correclty found", 19, locationsByRegion.size());
    }
}
