package com.realdolmen.travel.converter;

import com.realdolmen.travel.domain.Region;
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
@FacesConverter(value = "regionConverter")
public class RegionConverter implements Converter {
    @Inject
    RegionRepository repository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Long id = Long.parseLong(value);
        Region region = repository.find(id);
//        logger.info("The name of the region is " + region.getName());
        return region;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value == null || value.toString().isEmpty() || !(value instanceof Region)){
            return "";
        }
        Long id = ((Region) value).getId();
//        logger.info("Converter get as String. Id = " + id);
        return String.valueOf(((Region) value).getId());
    }
}
