package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Booking;
import com.realdolmen.travel.domain.Customer;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Stateless
public class BookingRepository extends AbstractRepository<Booking>{
    public List<Booking> findAllBookingsByCustomer(Customer customer) {
        TypedQuery<Booking> query = null;
        String jpqlQuery = "Select b from Booking b where b.customer.id = :customer_id";
        query = em.createQuery(jpqlQuery, Booking.class);
        query.setParameter("customer_id", customer.getId());
        return query.getResultList();
    }
}
