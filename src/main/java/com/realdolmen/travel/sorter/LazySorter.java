package com.realdolmen.travel.sorter;

import com.realdolmen.travel.domain.Flight;
import org.primefaces.model.SortOrder;

import java.util.Comparator;

/**
 * Created by JHRAU70 on 9/10/2014.
 */
public class LazySorter implements Comparator<Flight> {
    private String sortField;

    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(Flight flight1, Flight flight2) {
        try {
            Object value1 = Flight.class.getField(this.sortField).get(flight1);
            Object value2 = Flight.class.getField(this.sortField).get(flight2);

            int value = ((Comparable)value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
