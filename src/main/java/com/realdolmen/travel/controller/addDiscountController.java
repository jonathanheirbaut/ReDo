package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Discount;
import com.realdolmen.travel.service.DiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;


@Named
@RequestScoped
public class AddDiscountController {
    @Inject
    private DiscountService discountService;
    @Inject
    private UserController userController;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Min(value=1, message="The minimum threshold is 1")
    private Integer threshold;
    private String discountPercentage;
    private Discount discount;

    public AddDiscountController() {
    }

    public String addDiscount() {
        discount = new Discount();
        logger.info("threshold: " + threshold);
        logger.info("percentage: " + discountPercentage);
        discount.setDiscount(percentageToDouble(discountPercentage));
        discount.setThreshold(threshold);
        discount.setPartner(userController.getUserAsAirlineEmployee().getPartner());
        discountService.addDiscount(discount);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO,"The discount is successfully added", ""));
        threshold=null;
        discount=null;
        discountPercentage=null;
        return null;
    }
    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    private Double percentageToDouble(String discountPercentage){
        discountPercentage = discountPercentage.substring(0,2);
        Double discountNumber = Double.parseDouble(discountPercentage);
        discountNumber/=100;
        return discountNumber;
    }
}
