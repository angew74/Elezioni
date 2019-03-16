/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IAuthorityService;
import com.deltasi.elezioni.model.authentication.Authorities;
import com.deltasi.elezioni.model.authentication.User;
import java.util.List;
import javax.transaction.Transactional;

import com.deltasi.elezioni.repository.AuthorityDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AdminDSI
 */
@Service
@Transactional
public class AuthorityService implements IAuthorityService{

      private static final Logger logger = LogManager.getLogger(UserService.class);
    
    @Autowired
    private AuthorityDAO authorityDAO;
    
    @Override
    public void addUtenteToAuthority(Authorities authority) {
       authorityDAO.save(authority);
    }

    @Override
    public List<User> getAllUtentiByAuthority(String authority) {
     return  authorityDAO.findAllByAuthority(authority);
    }

    @Override
    public void removeUtenteFromAuthoriy(Integer iduser, String authority) {
       authorityDAO.deleteByUserIdAndAndAuthority(iduser,authority);
    }

    @Override
    public List<Authorities> getAuthorityByUtente(String UserName) {

        return authorityDAO.findAllByUserUsername(UserName);
    }
    
}
