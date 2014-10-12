package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Booking;
import com.realdolmen.travel.domain.Customer;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.exception.BookingServiceException;
import com.realdolmen.travel.repository.BookingRepository;
import com.realdolmen.travel.repository.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Stateless
public class BookingService {
    @Inject
    BookingRepository bookingRepository;
    @Inject
    TripRepository tripRepository;


    private Logger logger = LoggerFactory.getLogger(getClass());

    public boolean createBooking(Booking booking) throws BookingServiceException {
        if (booking.getNumberOfPeople() > booking.getTrip().getEmptyPlaces()) {
            throw new BookingServiceException("There are not enough places on this trip!");
        }

        Trip trip = tripRepository.find(booking.getTrip().getId());

        if (trip.getEmptyPlaces()<booking.getNumberOfPeople()){
            throw new BookingServiceException("The trip was already sold out");
        }

        trip.setEmptyPlaces(trip.getEmptyPlaces() - booking.getNumberOfPeople());

        try {
            tripRepository.update(trip);
            bookingRepository.create(booking);
        } catch (OptimisticLockException exception) {
            throw new BookingServiceException("The trip was already sold out");
        }
        return true;
    }

    public List<Booking> findAllBookingsByCustomer(Customer customer) {
        return bookingRepository.findAllBookingsByCustomer(customer);
    }
}
