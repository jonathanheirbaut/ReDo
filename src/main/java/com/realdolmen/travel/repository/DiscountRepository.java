package com.realdolmen.travel.repository;

 import com.realdolmen.travel.domain.Discount;
 import com.realdolmen.travel.domain.Partner;
 import javax.ejb.Stateless;
 import javax.persistence.TypedQuery;
 import java.util.List;

/**
 * Created by KVEAU50 on 10/10/2014.
 */

@Stateless
public class DiscountRepository  extends AbstractRepository<Discount> {
    public List<Discount> findAllByPartner(Partner partner) {
        TypedQuery<Discount> query = null;
        String jpqlQuery = "Select d from Discount d where d.partner.id = :partner_id";
        query = em.createQuery(jpqlQuery, Discount.class);
        query.setParameter("partner_id", partner.getId());
        return query.getResultList();
    }
}
