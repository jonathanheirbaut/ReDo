package com.realdolmen.travel.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Calendar;
import java.util.Date;

@FacesValidator("dateTimeValidator")
public class DateTimeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return; // Let required="true" handle.
        }
        Date d = (Date)value;
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        if(c.get(Calendar.MINUTE)<30 && c.get(Calendar.HOUR)==0){
            throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "A flight has to take longer then 30 minutes", null));
        }
        }


    }

