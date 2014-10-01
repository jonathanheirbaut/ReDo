package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partner extends AbstractEntity {

    private String name;
    @OneToMany(mappedBy = "partner")
    private List<Flight> flights = new ArrayList<Flight>();
    @OneToMany
    private List<Discount> discounts = new ArrayList<Discount>();

    protected Partner() {
    }

    public Partner(String name, List<Flight> flights, List<Discount> discounts) {
        this.name = name;
        this.flights = flights;
        this.discounts = discounts;
    }

    public Long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
