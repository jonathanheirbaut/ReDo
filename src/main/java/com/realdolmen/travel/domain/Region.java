package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Region extends AbstractEntity {

    private String name;
    private String code;
    @OneToMany(mappedBy="region")
    private List<Location> locations = new ArrayList<Location>();

    protected Region() {
    }

    public Region(String name, String code, List<Location> locations) {
        this.name = name;
        this.code = code;
        this.locations = locations;
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

    public List<Location> getLocations() {
        return locations;
    }
}
