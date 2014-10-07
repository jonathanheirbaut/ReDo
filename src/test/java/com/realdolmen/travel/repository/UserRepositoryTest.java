package com.realdolmen.travel.repository;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
import com.realdolmen.travel.domain.*;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@RunWith(Arquillian.class)
public class UserRepositoryTest extends AbstractArquillianTestCase {
    @Inject
    private UserRepository userRepository;

    @Test
    public void canPersistCustomer() throws Exception {
        User customer = new Customer("ikke", "ikke");
        userRepository.create(customer);
        assertNotNull("Customer could not be peristed", customer.getId());
    }

    @Test
    public void canPersistArlineEmployee() throws Exception {
        User airlineEmployee = new AirlineEmployee("ikke", "ikke", null);
        userRepository.create(airlineEmployee);
        assertNotNull("AirlineEmployee could not be peristed", airlineEmployee.getId());
    }

    @Test
    public void canPersistRDAirEmployee() throws Exception {
        User rdAirEmployee = new RDAirEmployee("ikke", "ikke");
        userRepository.create(rdAirEmployee);
        assertNotNull("RDAirEmployee could not be peristed", rdAirEmployee.getId());
    }

    @Test
    public void canPersistRDTravelEmployee() throws Exception {
        User rdTravelEmployee = new RDTravelEmployee("ikke", "ikke");
        userRepository.create(rdTravelEmployee);
        assertNotNull("RDTravelEmployee could not be peristed", rdTravelEmployee.getId());
    }

}
