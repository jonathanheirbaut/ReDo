package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Booking;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.exception.BookingServiceException;
import com.realdolmen.travel.repository.BookingRepository;
import com.realdolmen.travel.repository.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;

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

    public void createBooking(Booking booking) throws BookingServiceException {
        if(booking.getNumberOfPeople()>booking.getTrip().getEmptyPlaces()){
            throw new BookingServiceException("There are not enough places on this trip!");
        }
        Trip trip = booking.getTrip();
        trip.setEmptyPlaces(trip.getEmptyPlaces()-booking.getNumberOfPeople());
        tripRepository.update(trip);
        bookingRepository.create(booking);
    }
}
