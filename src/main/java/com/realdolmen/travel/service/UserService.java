package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.User;
import com.realdolmen.travel.exception.UserServiceException;
import com.realdolmen.travel.repository.UserRepository;

import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
public class UserService {
    private static final String SALT = "ReDOtRaVel";

    @Inject
    private UserRepository userRepository;

    public void checkLogin(String username, String password) throws UserServiceException
    {
        User user;
        try
        {
            user = userRepository.findUserByUsername(username);
            // mogelijk is user null -> NullPointerException
            if (!user.getPassword().equals(encryptPassword(password)));
            {
                throw new UserServiceException(("Invalid username or password"));
            }
        }
        catch (Exception ex)
        {
            throw new UserServiceException(("Invalid username or password"));
        }

    }

    public void addUser(User user)
    {
        user.setPassword(encryptPassword(user.getPassword()));
        userRepository.create(user);
    }

    private String encryptPassword(String password) {
        String passwordToHash = SALT+password;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
