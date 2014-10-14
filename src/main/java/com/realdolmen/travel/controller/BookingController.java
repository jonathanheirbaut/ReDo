package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Booking;
import com.realdolmen.travel.domain.Customer;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.exception.BookingServiceException;
import com.realdolmen.travel.service.BookingService;
import com.realdolmen.travel.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

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
    TripService tripService;
    @Inject
    UserController userController;
    @Inject
    TripController tripController;

    private Trip trip;

    @PostConstruct
    public void init(){
//        Long tripId = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
//        trip = tripService.findById(tripId);

    }


    public String createBooking() {
        Trip selectedTrip = userController.getSelectedTrip();
        Integer numberOfPersons = userController.getNumberOfPersons();
        boolean bookingSuccess = false;

        Booking booking = new Booking();
        booking.setCustomer(userController.getUserAsCustomer());
        booking.setTrip(selectedTrip);
        booking.setNumberOfPeople(numberOfPersons);
        booking.setPrice(tripService.calculateTripPrice(selectedTrip, numberOfPersons).doubleValue());
        logger.info("trip: " + selectedTrip);
        try {
          bookingSuccess =  bookingService.createBooking(booking);
        } catch (BookingServiceException e) {
           bookingSuccess = false;
        }
        userController.resetBooking();
        if (bookingSuccess){
            return "bookingComplete";
        }
        else return "bookingSoldOut";
    }

    public String goToConfirmPage() {
        return "confirmBooking";
    }

    public List<Booking> findAllBookingsByCustomer(Customer customer) {
        return bookingService.findAllBookingsByCustomer(customer);
    }

}
