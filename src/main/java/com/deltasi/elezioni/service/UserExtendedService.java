package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IUserExtendedService;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;
import com.deltasi.elezioni.repository.UserExtendedDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public List<UserExtended> findAll() {
        return userExtendedDAO.findAllBy();
    }

    @Override
    public Page<UserExtended> findAll(Pageable pageable) {
        return userExtendedDAO.findAllBy(pageable);
    }

    @Override
    public void addUtente(UserExtended utente) {
        userExtendedDAO.save(utente);
    }

    @Override
    public UserExtended updateUtente(UserExtended utente) {
        return userExtendedDAO.saveAndFlush(utente);
    }
}
