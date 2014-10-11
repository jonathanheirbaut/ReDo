package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Trip;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Stateless
public class TripRepository extends AbstractRepository<Trip> {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public List<Trip> getAvailableTripsBySearchValues(Location fromLocation, Location toLocation, Date from, Date to, Integer numberOfPersons) {
        TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t WHERE t.outwardFlight.departure = :fromLocation" +
                " AND t.outwardFlight.destination = :toLocation" +
                " AND t.outwardFlight.arrivalDate > :from" +
                " AND t.returnFlight.departureDate < :to" +
                " AND t.emptyPlaces >= :numberOfPersons", Trip.class);
        logger.info("fromLocation: " + fromLocation.getName());
        logger.info("toLocation: " + toLocation.getName());
        logger.info("from: " + from);
        logger.info("to: " + to);
        query.setParameter("fromLocation", fromLocation);
        query.setParameter("toLocation", toLocation);
        query.setParameter("from", from);
        query.setParameter("to", to);
        query.setParameter("numberOfPersons", numberOfPersons);
        return query.getResultList();
    }

    public BigDecimal calculateTripPrice(Location toLocation, Flight outwardFlight, Flight returnFlight, Integer numberOfPeople) {
        BigDecimal tripPrice;
        //Calculate price for stay at the location
        BigDecimal pricePerDay = new BigDecimal(toLocation.getPrice());
      /*  DateTime fromDate = new DateTime(outwardFlight.getArrivalDate().getTime());
        DateTime toDate = new DateTime(returnFlight.getDepartureDate().getTime());
        BigDecimal numberOfDays =  new BigDecimal(Days.daysBetween(fromDate, toDate).getDays() + 2);*/
        BigDecimal numberOfDays = new BigDecimal(calculateDaysBetween(outwardFlight.getArrivalDate(), returnFlight.getDepartureDate()) + 1);
        logger.info("Days between: " + numberOfDays);

        //Calculate price of the flights
        Double discountOutwardFlight = getGrantedDiscount(outwardFlight, numberOfPeople);
        Double discountreturnFlight = getGrantedDiscount(returnFlight, numberOfPeople);


        BigDecimal priceOutwardFlight = new BigDecimal(outwardFlight.getPrice() * (1 - discountOutwardFlight));
        BigDecimal priceReturnFlight = new BigDecimal(returnFlight.getPrice() * (1 - discountreturnFlight));

        //Calculate end price for the number of people
        tripPrice = pricePerDay.multiply(new BigDecimal(numberOfPeople)).multiply(numberOfDays).add(priceOutwardFlight).add(priceReturnFlight);

        return tripPrice;
    }

/*    private Double getGrantedDiscount(Flight flight, Integer numberOfPeople) {
        TypedQuery<Double> query = em.createQuery("SELECT MAX(d.discount) from Discount d WHERE d.threshold = (SELECT MAX(d.threshold) FROM Discount d WHERE :numberOfPeople >= d.threshold) AND d.partner.id = :partner_id", Double.class);

        query.setParameter("numberOfPeople", numberOfPeople);
        query.setParameter("partner_id", flight.getPartner().getId());
        return query.getSingleResult();
    }*/

    private Double getGrantedDiscount(Flight flight, Integer numberOfPeople) {
        TypedQuery<Integer> query1 = em.createQuery("SELECT MAX(d.threshold) FROM Discount d WHERE :numberOfPeople >= d.threshold AND d.partner.id = :partner_id", Integer.class);
        query1.setParameter("numberOfPeople", numberOfPeople);
        query1.setParameter("partner_id", flight.getPartner().getId());
        Integer threshold = query1.getSingleResult();

        TypedQuery<Double> query2 = em.createQuery("SELECT MAX(d.discount) FROM Discount d WHERE d.threshold = :threshold AND d.partner.id = :partner_id", Double.class);
        query2.setParameter("threshold", threshold);
        query2.setParameter("partner_id", flight.getPartner().getId());
        Double result = query2.getSingleResult();

        logger.info("Bla: " + result);
        if (result == null) return 0.0;
        return result;
    }

    private int calculateDaysBetween(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int dayOfYear1 = cal1.get(Calendar.DAY_OF_YEAR);
        int dayOfYear2 = cal2.get(Calendar.DAY_OF_YEAR);
        return dayOfYear2 - dayOfYear1;
    }
}
