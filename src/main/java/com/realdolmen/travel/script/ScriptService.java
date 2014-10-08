package com.realdolmen.travel.script;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;

import javax.persistence.*;
import java.util.*;

public class ScriptService {

    private List<Location> locations = new ArrayList<Location>();
    private List<Partner> partners = new ArrayList<Partner>();

    public ScriptService() {

    }

    public void createRandomFlights(int number) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("KerisPu");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            locations = findAllLocations(entityManager);
            partners = findAllPartners(entityManager);
            persistFlights(entityManager, number);
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

    private void persistFlights(EntityManager entityManager, int total) {

        for (int i = 0; i < total; i++) {

            Date departureDate = generateNewDate(new Date());
            Date arrivalDate = generateNewDate(departureDate);
            Integer departureId = 0;
            Integer destinationId = 0;

            Boolean isEqual = true;
            while (isEqual) {
                departureId = generateRandomNumber(0, locations.size()-1);
                destinationId = generateRandomNumber(0,locations.size()-1);
                if (departureId != destinationId) {
                    isEqual = false;
                }
            }


            Flight flight = new Flight(departureDate, arrivalDate, (double) generateRandomNumber(10, 1000), null, locations.get(departureId), locations.get(destinationId), partners.get(generateRandomNumber(0, partners.size() - 1)), generateRandomNumber(0, 60));
            entityManager.persist(flight);
        }


    }

    private List<Partner> findAllPartners(EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT p FROM Partner p");
        List<Partner> partners = query.getResultList();
        return partners;
    }

    private Integer generateRandomNumber(int lower, int upper) {
        Random r = new Random();
        int randomNumber = r.nextInt(upper - lower) + lower;
        return randomNumber;
    }

    private Date generateNewDate(Date date) {
        Date generatedDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, generateRandomNumber(1, 12));
        generatedDate = c.getTime();
        return generatedDate;
    }


}
