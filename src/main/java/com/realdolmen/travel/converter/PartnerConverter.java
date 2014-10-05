package com.realdolmen.travel.converter;

import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.PartnerRepository;
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
@FacesConverter(value = "partnerConverter")
public class PartnerConverter implements Converter {
    @Inject
    PartnerRepository repository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Long id = Long.parseLong(value);
        Partner partner = repository.find(id);
        logger.info("The name of the partner is " + partner.getName());
        return partner;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value == null || value.toString().isEmpty() || !(value instanceof Partner)){
            return "";
        }
        return String.valueOf(((Partner) value).getId());
    }
}
