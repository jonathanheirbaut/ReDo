package com.realdolmen.travel.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;
import java.util.ResourceBundle;

@FacesValidator("dateRangeValidator")
public class DateValidator implements Validator {
    private ResourceBundle bundle;
    private FacesMessage msg;
    public DateValidator() {
        bundle = ResourceBundle.getBundle("com.realdolmen.travel.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        msg = new FacesMessage();

    }

    @Override


    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return; // Let required="true" handle.
        }

        UIInput startDateComponent = (UIInput) component.getAttributes().get("startDateComponent");

        if (!startDateComponent.isValid()) {
            return; // Already invalidated. Don't care about it then.
        }

        Date startDate = (Date) startDateComponent.getValue();

        if (startDate == null) {
            return; // Let required="true" handle.
        }

        Date endDate = (Date) value;

        if (startDate.after(endDate)) {
            startDateComponent.setValid(false);
            String errorMsg = bundle.getString("errorStartDateAfterEndDate");
            msg.setSummary(errorMsg);
            msg.setDetail(null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}