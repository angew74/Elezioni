package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IUserExtendedService;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;
import com.deltasi.elezioni.repository.UserExtendedDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserExtendedService implements IUserExtendedService {


   private static final Logger logger = LogManager.getLogger(UserExtendedService.class);

    @Autowired
    private UserExtendedDAO userExtendedDAO;


    @Override
    public UserExtended findById(Integer id) {
      return userExtendedDAO.findById(id);
    }

    @Override
    public UserExtended findByUser(User user) {
       return  userExtendedDAO.findByUser(user);
    }

    @Override
    public UserExtended findByUserUsername(String userName) {
       return userExtendedDAO.findByUserUsername(userName);
    }
}
