package com.realdolmen.travel.script;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ScriptService {

    private List<Location> locations = new ArrayList<Location>();
    private List<Partner> partners = new ArrayList<Partner>();

    public ScriptService() {

    }

    public void createFlight(Flight flight) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("KerisPu");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            locations = findAllLocations(entityManager);
            partners = findAllPartners(entityManager);
            persistFlights(entityManager, 5);
            transaction.commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    private List<Location> findAllLocations(EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT l FROM Location l");
        List<Location> locations = query.getResultList();
        return locations;
    }

    private void persistFlights(EntityManager entityManager, int total){
        Flight flight = new Flight(null,null,null,null,locations.get(1), locations.get(2), partners.get(1),null);
        entityManager.persist(flight);
    }

    private List<Partner> findAllPartners(EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT p FROM Partner p");
        List<Partner> partners = query.getResultList();
        return partners;
    }


}
