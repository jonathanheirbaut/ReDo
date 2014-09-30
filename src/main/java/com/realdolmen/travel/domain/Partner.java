package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partner {

    @Version
    private Long version;
    @Id @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "partner")
    private List<Flight> flights = new ArrayList<Flight>();
    @OneToMany
    private List<Discount> discounts = new ArrayList<Discount>();

    public Partner() {
    }

    public Partner(String name, List<Flight> flights, List<Discount> discounts) {
        this.name = name;
        this.flights = flights;
        this.discounts = discounts;
    }

    public Long getVersion() {
        return version;
    }

    public Integer getId() {
        return id;
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
