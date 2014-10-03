package com.realdolmen.travel.converter;

import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.RegionRepository;

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

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        System.out.println("ik kom hier!");
        Long id = Long.parseLong(value);
        Region region = repository.find(id);
        System.out.println(region.getName());
        return region;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value == null || value.toString().isEmpty() || !(value instanceof Region)){
            System.out.printf("I shouldn't be here");
            return "";
        }
        return String.valueOf(((Region) value).getId());
    }
}
