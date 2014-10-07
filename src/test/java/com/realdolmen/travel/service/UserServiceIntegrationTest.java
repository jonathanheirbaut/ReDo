package com.realdolmen.travel.service;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
import com.realdolmen.travel.domain.AirlineEmployee;
import com.realdolmen.travel.domain.Partner;
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
public class UserServiceIntegrationTest extends AbstractArquillianTestCase {
    @Inject
    private UserService userService;
    @Inject PartnerService partnerService;

    @Test
    public void canPersistAUser() throws Exception {
        User user = new AirlineEmployee("ikke", "ikke", null);
        userService.addUser(user);
        logger.info(user.getPassword());
        assertNotNull("User could not be peristed", user.getId());
    }
}
