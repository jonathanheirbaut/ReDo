package com.realdolmen.travel.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.sorter.LazySorter;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 * Created by JHRAU70 on 9/10/2014.
 */

public class LazyFlightModel extends LazyDataModel<Flight> {

    private List<Flight> datasource;

    public LazyFlightModel(List<Flight> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Flight getRowData(String rowKey) {
        for(Flight flight : datasource) {
            if((""+flight.getId()).equals(rowKey))
                return flight;
        }
        return null;
    }

    @Override
    public Object getRowKey(Flight flight) {
        return flight.getId();
    }


    @Override
    public List<Flight> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Flight> data = new ArrayList<>();

        //filter
        for(Flight flight : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(flight.getClass().getField(filterProperty).get(flight));

                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        }
                        else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }

            if(match) {
                data.add(flight);
            }
        }

      //sort
        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}
