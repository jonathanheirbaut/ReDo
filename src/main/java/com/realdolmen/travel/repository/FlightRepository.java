package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Stateless
public class FlightRepository extends AbstractRepository<Flight> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Double calculateMinimumPrice(Region departureRegion, Region destinationRegion, Date startDate, Date endDate, Partner partner) {
        String jpqlQuery = "select min(f.price) from Flight f where 1=1";
        return createDynamicQuery(jpqlQuery, departureRegion, destinationRegion, startDate, endDate, partner);
    }

    public Double calculateMaximumPrice(Region departureRegion, Region destinationRegion, Date startDate, Date endDate, Partner partner) {
        String jpqlQuery = "select max(f.price) from Flight f where 1=1";
        return createDynamicQuery(jpqlQuery, departureRegion, destinationRegion, startDate, endDate, partner);
    }

    public Double calculateAveragePrice(Region departureRegion, Region destinationRegion, Date startDate, Date endDate, Partner partner) {
        String jpqlQuery = "Select avg(f.price) from Flight f where 1=1";
        return createDynamicQuery(jpqlQuery, departureRegion, destinationRegion, startDate, endDate, partner);
    }

    private Double createDynamicQuery(String jpqlQuery, Region departureRegion, Region destinationRegion, Date startDate, Date endDate, Partner partner) {
        {
            TypedQuery<Double> query = null;
            if (departureRegion != null) jpqlQuery += " and f.departure.region.name = :departureRegion";
            if (destinationRegion != null) jpqlQuery += " and f.destination.region.name = :destinationRegion";
            if (startDate != null) jpqlQuery += " and f.departureDate >=:startDate";
            if (endDate != null) jpqlQuery += " and f.departureDate >=:endDate";
            if(partner !=null)jpqlQuery+= " and f.partner.name = :partner";


            query = em.createQuery(jpqlQuery, Double.class);

            if (departureRegion != null) query.setParameter("departureRegion", departureRegion.getName());
            if (destinationRegion != null) query.setParameter("destinationRegion", destinationRegion.getName());
            if (startDate != null) query.setParameter("startDate", startDate);
            if (endDate != null) query.setParameter("endDate", endDate);
            if(partner!=null)query.setParameter("partner", partner.getName());
            logger.info(jpqlQuery);
            return query.getSingleResult();
        }

    }

    public List<Flight> findAllByPartner(Partner partner) {

        TypedQuery<Flight> query = null;
        String jpqlQuery = "Select f from Flight f where f.partner.id = :partner_id";
        query = em.createQuery(jpqlQuery, Flight.class);
        query.setParameter("partner_id", partner.getId());

        return query.getResultList();
    }


}

