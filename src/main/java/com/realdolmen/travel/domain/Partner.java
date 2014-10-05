package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partner extends AbstractEntity {

    private String name;
//    @OneToMany(mappedBy = "partner")
//    private List<Flight> flights = new ArrayList<Flight>();
//    @OneToMany
//    private List<Discount> discounts = new ArrayList<Discount>();

    protected Partner() {
    }

    public Partner(String name, List<Flight> flights, List<Discount> discounts) {
        this.name = name;
      ///  this.flights = flights;
     //   this.discounts = discounts;
    }

    public Long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

//    public List<Flight> getFlights() {
//        return flights;
//    }

  //  public List<Discount> getDiscounts() {
//        return discounts;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partner partner = (Partner) o;

        if (name != null ? !name.equals(partner.name) : partner.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void setName(String name) {
        this.name = name;
    }
}
