package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.AbstractRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

@Stateless
public class FlightRepository extends AbstractRepository<Flight> {

    public Double calculateAveragePrice() {
        return em.createQuery("select avg(f.price) from Flight f", Double.class).getSingleResult();
    }

    public Double calculateMinimumPrice() {
        return em.createQuery("select min(f.price) from Flight f", Double.class).getSingleResult();
    }

    public Double calculateMaximumPrice() {
        return em.createQuery("select max(f.price) from Flight f", Double.class).getSingleResult();
    }

    public Double testCalculateAveragePrice(Location departure, Location destination, Region departureRegion, Region destinationRegion) {
        Query query = null;
        String jpqlQuery = "Select avg(f.price) from Flight f where 1=1";

        if (departure != null)jpqlQuery += " and f.departure.name = :departure";
        if (destination != null)jpqlQuery += " and f.destination.name = :destination";
        if (departureRegion != null)jpqlQuery += " and f.departure.region.name = :departureRegion";
        if (destinationRegion != null)jpqlQuery += " and f.destination.region.name = :destinationRegion";

        query = em.createQuery(jpqlQuery, Double.class);

        if(departure!=null)query.setParameter("departure", departure.getName());
        if(destination!=null)query.setParameter("destination", destination.getName());
        if(departureRegion!=null)query.setParameter("departureRegion", departureRegion.getName());
        if(destinationRegion!=null)query.setParameter("destinationRegion", destinationRegion.getName());
        return (double) query.getSingleResult();
    }
}

