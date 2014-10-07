package com.realdolmen.travel.repository;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
import com.realdolmen.travel.domain.AirlineEmployee;
import com.realdolmen.travel.domain.Customer;
import com.realdolmen.travel.domain.User;
import com.realdolmen.travel.domain.UserType;
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
    public void canPersistACustomer() throws Exception {
        User customer = new Customer("ikke", "ikke");
        userRepository.create(customer);
        assertNotNull("Customer could not be peristed", customer.getId());
    }

    @Test
    public void canPersistAArlineEmployee() throws Exception {
        User airlineEmployee = new AirlineEmployee("ikke", "ikke", null);
        userRepository.create(airlineEmployee);
        assertNotNull("AirlineEmployee could not be peristed", airlineEmployee.getId());
    }

}
