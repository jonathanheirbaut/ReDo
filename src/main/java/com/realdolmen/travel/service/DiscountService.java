package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Discount;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.repository.DiscountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by KVEAU50 on 10/10/2014.
 */
@Stateless
public class DiscountService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private DiscountRepository discountRepository;
    public void addDiscount(Discount discount) {
    discountRepository.create(discount);

    }

    public List<Discount> findAllByPartner(Partner partner) {
        return discountRepository.findAllByPartner(partner);
    }
}
