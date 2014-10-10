package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partner extends AbstractEntity {

    private String name;

    public Partner() {
    }

    public Long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

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
