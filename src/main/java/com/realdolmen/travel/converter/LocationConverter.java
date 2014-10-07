package com.realdolmen.travel.converter;

import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.LocationRepository;
import com.realdolmen.travel.repository.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Stateless
@FacesConverter(value = "locationConverter")
public class LocationConverter implements Converter {
    @Inject
    LocationRepository repository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Long id = Long.parseLong(value);
        Location location = repository.find(id);
        logger.info("The name of the location is " + location.getName());
        return location;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value == null || value.toString().isEmpty() || !(value instanceof Location)){
            return "";
        }
        return String.valueOf(((Location) value).getId());
    }
}
