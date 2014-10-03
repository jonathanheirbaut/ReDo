package com.realdolmen.travel.repository;

import com.realdolmen.travel.domain.User;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@Stateless
public class UserRepository extends AbstractRepository<User> {

    public User findUserByUsername(String username) {
        User user = null;
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.userName = :uName", User.class);
            query.setParameter("uName", username);
            user = query.getSingleResult();
        } catch (Exception e){

        }
        return user;
    }
}
