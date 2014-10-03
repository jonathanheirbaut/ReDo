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

    public Region() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (code != null ? !code.equals(region.code) : region.code != null) return false;
        if (locations != null ? !locations.equals(region.locations) : region.locations != null) return false;
        if (name != null ? !name.equals(region.name) : region.name != null) return false;

        if (((Region)o).getId() == this.getId()) return true;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (locations != null ? locations.hashCode() : 0);
        return result;
    }
}
