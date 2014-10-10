package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Booking;
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

    private Trip selectedTrip;
    private Integer numberOfPersons;


    private Booking booking;

    public String createBooking(Integer numberOfPersons){

        try {
            booking = new Booking();
            booking.setCustomer(userController.getUserAsCustomer());
            booking.setTrip(selectedTrip);
booking.setNumberOfPeople(numberOfPersons);
            logger.info("trip: " + selectedTrip);
            bookingService.createBooking(booking);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Your booking has been submitted!"));

        } catch (BookingServiceException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
        }
        return null;
    }

    public Trip getSelectedTrip() {
        return selectedTrip;
    }

    public void setSelectedTrip(Trip selectedTrip) {
        this.selectedTrip = selectedTrip;
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
