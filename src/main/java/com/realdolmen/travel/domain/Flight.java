package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.Date;
import org.primefaces.model.SelectableDataModel;


@Entity
public class Flight extends AbstractEntity{

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;
    private Double price;
    private Double overriddenPrice;
    @ManyToOne
    private Location destination;
    @ManyToOne
    private Location departure;
    @ManyToOne
    private Partner partner;
    private Integer emptySeats;

    public Flight() {
    }

    public Flight(Date departureDate, Date arrivalDate, Double price, Double overriddenPrice, Location departure, Location destination, Partner partner, Integer emptySeats) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.overriddenPrice = overriddenPrice;
        this.departure = departure;
        this.destination = destination;
        this.partner = partner;
        this.emptySeats = emptySeats;
    }

    public Long getVersion() {
        return version;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Double getPrice() {
        return price;
    }

    public Double getOverriddenPrice() {
        return overriddenPrice;
    }

    public Location getDeparture() {
        return departure;
    }

    public Location getDestination() {
        return destination;
    }

    public Partner getPartner() {
        return partner;
    }

    public Integer getEmptySeats() {
        return emptySeats;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setOverriddenPrice(Double overriddenPrice) {
        this.overriddenPrice = overriddenPrice;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public void setEmptySeats(Integer emptySeats) {
        this.emptySeats = emptySeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (arrivalDate != null ? !arrivalDate.equals(flight.arrivalDate) : flight.arrivalDate != null) return false;
        if (departure != null ? !departure.equals(flight.departure) : flight.departure != null) return false;
        if (departureDate != null ? !departureDate.equals(flight.departureDate) : flight.departureDate != null)
            return false;
        if (destination != null ? !destination.equals(flight.destination) : flight.destination != null) return false;
        if (emptySeats != null ? !emptySeats.equals(flight.emptySeats) : flight.emptySeats != null) return false;
        if (overriddenPrice != null ? !overriddenPrice.equals(flight.overriddenPrice) : flight.overriddenPrice != null)
            return false;
        if (partner != null ? !partner.equals(flight.partner) : flight.partner != null) return false;
        if (price != null ? !price.equals(flight.price) : flight.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departureDate != null ? departureDate.hashCode() : 0;
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (overriddenPrice != null ? overriddenPrice.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (partner != null ? partner.hashCode() : 0);
        result = 31 * result + (emptySeats != null ? emptySeats.hashCode() : 0);
        return result;
    }
}
