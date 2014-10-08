package com.realdolmen.travel.validator;

import com.realdolmen.travel.domain.Location;

import javax.faces.application.FacesMessage;
import javax.faces.component.*;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

@FacesValidator("locationCantBeEqualValidator")
public class LocationCantBeEqualValidator implements Validator {
    private ResourceBundle bundle;
    private FacesMessage msg;

    public LocationCantBeEqualValidator() {
        bundle = ResourceBundle.getBundle("com.realdolmen.travel.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        msg = new FacesMessage();

    }

    @Override
        public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return; // Let required="true" handle.
        }

        HtmlSelectOneMenu departureComponent = (HtmlSelectOneMenu) component.getAttributes().get("departureComponent");
        Location departure = (Location)departureComponent.getValue();
        if (departure == null) {
            return; // Let required="true" handle.
        }
        Location destination = (Location)value;
        if (departure.getId()==destination.getId()) {
            departureComponent.setValid(false);
            String errorMsg = bundle.getString("errorDepartureAndDestinationEqual");
            msg.setSummary(errorMsg);
            msg.setDetail(null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);        }
    }

}