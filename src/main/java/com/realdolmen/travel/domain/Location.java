package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location extends AbstractEntity {

    private String name;
    private String code;

    @ManyToOne
    private Region region;

   // @OneToMany(mappedBy = "destination")
    //private List<Flight> outgoingFlights = new ArrayList<Flight>();

    protected Location() {
    }

    public Location(String name, String code, Region region, List<Flight> outgoingFlights, List<Flight> incomingFlights) {
        this.name = name;
        this.code = code;
        this.region = region;
//        this.outgoingFlights = outgoingFlights;

    }

    public Long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Region getRegion() {
        return region;
    }

//    public List<Flight> getOutgoingFlights() {
//        return outgoingFlights;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (code != null ? !code.equals(location.code) : location.code != null) return false;
        if (name != null ? !name.equals(location.name) : location.name != null) return false;
        if (region != null ? !region.equals(location.region) : location.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }
}
