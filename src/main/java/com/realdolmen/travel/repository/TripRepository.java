package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Trip;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Stateless
public class TripRepository extends AbstractRepository<Trip> {

    public List<Trip> getAvailableTripsBySearchValues(Location fromLocation, Location toLocation, Date from, Date to, Integer numberOfPersons) {
        TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t WHERE t.outwardFlight.departure = :fromLocation" +
                " AND t.outwardFlight.destination = :toLocation" +
                " AND t.outwardFlight.arrivalDate >= :from" +
                " AND t.returnFlight.departureDate < :to" +
                " AND t.emptyPlaces >= :numberOfPersons", Trip.class);
        query.setParameter("fromLocation", fromLocation);
        query.setParameter("toLocation", toLocation);
        query.setParameter("from", from);
        query.setParameter("to", to);
        query.setParameter("numberOfPersons", numberOfPersons);
        return query.getResultList();
    }
}
