package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.repository.AbstractRepository;

import javax.ejb.Stateless;

@Stateless
public class FlightRepository extends AbstractRepository<Flight> {

    public Double calculateAveragePrice() {
        return em.createQuery("select avg(f.price) from Flight f", Double.class).getSingleResult();
    }
    public Double calculateMinimumPrice(){
        return em.createQuery("select min(f.price) from Flight f", Double.class).getSingleResult();
    }
    public Double calculateMaximumPrice(){
        return em.createQuery("select max(f.price) from Flight f", Double.class).getSingleResult();
    }
}
