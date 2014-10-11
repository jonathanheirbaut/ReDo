package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Booking;
import com.realdolmen.travel.domain.Customer;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.exception.BookingServiceException;
import com.realdolmen.travel.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    UserController userController;
    @Inject
    TripController tripController;



    public String createBooking() {

            Booking booking = new Booking();
            booking.setCustomer(userController.getUserAsCustomer());
            booking.setTrip(userController.getSelectedTrip());
            booking.setNumberOfPeople(userController.getNumberOfPersons());
            logger.info("trip: " + userController.getSelectedTrip());
        try {
            bookingService.createBooking(booking);
        } catch (BookingServiceException e) {
            e.printStackTrace();
        }


        return "bookingComplete";
    }

    public String goToConfirmPage(){
        return "confirmBooking";
    }
    public List<Booking> findAllBookingsByCustomer(Customer customer){
        return bookingService.findAllBookingsByCustomer(customer);
    }

}
