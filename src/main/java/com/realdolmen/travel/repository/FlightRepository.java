package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.AbstractRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

@Stateless
public class FlightRepository extends AbstractRepository<Flight> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Double calculateMinimumPrice(Region departureRegion, Region destinationRegion) {
        String jpqlQuery = "select min(f.price) from Flight f where 1=1";
        return createDynamicQuery(jpqlQuery,departureRegion, destinationRegion);
    }

    public Double calculateMaximumPrice(Region departureRegion, Region destinationRegion) {
        String jpqlQuery = "select max(f.price) from Flight f where 1=1";
        return createDynamicQuery(jpqlQuery, departureRegion, destinationRegion);
    }

    public Double calculateAveragePrice(Region departureRegion, Region destinationRegion) {
        String jpqlQuery = "Select avg(f.price) from Flight f where 1=1";
        return createDynamicQuery(jpqlQuery, departureRegion, destinationRegion);
    }

    private Double createDynamicQuery(String jpqlQuery, Region departureRegion, Region destinationRegion) {
        TypedQuery<Double> query = null;
        if (departureRegion != null) jpqlQuery += " and f.departure.region.name = :departureRegion";
        if (destinationRegion != null) jpqlQuery += " and f.destination.region.name = :destinationRegion";

        query = em.createQuery(jpqlQuery, Double.class);

        if (departureRegion != null) query.setParameter("departureRegion", departureRegion.getName());
        if (destinationRegion != null) query.setParameter("destinationRegion", destinationRegion.getName());
        logger.info(jpqlQuery);
        return query.getSingleResult();
    }

}

