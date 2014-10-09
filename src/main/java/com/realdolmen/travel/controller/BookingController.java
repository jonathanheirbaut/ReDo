package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Booking;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 * Created by KVEAU50 on 9/10/2014.
 */
@ManagedBean
@ViewScoped
public class BookingController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Inject
    BookingService bookingService;
    @Inject
    UserController userController;

    private Trip selectedTrip;


    private Booking booking;

    public String createBooking(){
        booking = new Booking();
        booking.setCustomer(userController.getUserAsCustomer());
        booking.setTrip(selectedTrip);
        logger.info("trip: " + selectedTrip);
        bookingService.createBooking(booking);
        return null;
    }

    public Trip getSelectedTrip() {
        return selectedTrip;
    }

    public void setSelectedTrip(Trip selectedTrip) {
        this.selectedTrip = selectedTrip;
    }
}
