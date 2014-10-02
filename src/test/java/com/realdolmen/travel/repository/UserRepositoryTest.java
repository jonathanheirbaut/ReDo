package com.realdolmen.travel.repository;

import com.realdolmen.travel.common.AbstractArquillianTestCase;
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
    public void canPersistAUser() throws Exception {
        User user = new User("Jonathan", "jonathan", UserType.CUSTOMER);
        userRepository.create(user);
        assertNotNull("User could not be peristed", user.getId());
    }

}
