package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {

    @Version
    private Long version;
    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String code;
    @ManyToOne
    @JoinColumn(name="region_fk")
    private Region region;

    @OneToMany(mappedBy = "destination")
    private List<Flight> outgoingFlights = new ArrayList<Flight>();

    public Location() {
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

}
