package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Discount;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.service.DiscountService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by KVEAU50 on 10/10/2014.
 */
@Named
@RequestScoped
public class DiscountController{
    @Inject
    DiscountService discountService;

    public List<Discount> findAllByPartner(Partner partner) {
        return discountService.findAllByPartner(partner);
    }

}
