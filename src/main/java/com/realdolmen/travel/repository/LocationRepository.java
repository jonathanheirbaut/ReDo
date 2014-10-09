package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Stateless
public class LocationRepository extends AbstractRepository<Location> {
    public Collection<Location> getLocationsByRegion(Region region) {
        TypedQuery<Location> query = em.createQuery("SELECT l FROM Location l WHERE l.region = :region", Location.class);
        query.setParameter("region", region);
        return query.getResultList();
    }
}
