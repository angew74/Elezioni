/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IUserService;
import com.deltasi.elezioni.repository.UserDAO;
import com.deltasi.elezioni.model.authentication.User;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AdminDSI
 */
@Service("userDetailsService")
public class UserService implements UserDetailsService , IUserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    @Transactional 
    public void addUtente(User utente) {       
      userDAO.save(utente);
    }

    @Override
    @Transactional 
    public List<User> getAllUtenti() {             
       List<User> l = userDAO.findAll();
        return l;
    }

    @Override
    public void deleteUtente(Integer id) {
       userDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUtente(int id) {
        User user = userDAO.findById(id);
        user.getAuthorities();
        return user;
     
    }

    @Override
    @Transactional
    public User updateUtente(User utente) {
        return userDAO.saveAndFlush(utente);
    }
    
    @Transactional
    public User getByUsername(String username)
    {return userDAO.findByUsername(username);}
    
    
    
     @Override
     @Transactional
    public UserDetails loadUserByUsername(String username) {     
    User user = userDAO.findByUsername(username);
    org.springframework.security.core.userdetails.User.UserBuilder builder = null;
    logger.debug("Ho trovate user" + username);
    //logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("Sono in userdetails");
		}

    try 
    {
    if (user != null) {
      
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.disabled(!user.isEnabled());
      builder.password(user.getPassword());
      String[] authorities = user.getAuthorities()
          .stream().map(a -> a.getAuthority()).toArray(String[]::new);

      builder.authorities(authorities);  
     builder.roles(authorities);
    } else {
       logger.error("Utente non trovato");
      throw new UsernameNotFoundException("Utente non trovato");
    }
    }
    catch(Exception ex)
    {
         logger.error(ex.getMessage());
    }
    return builder.build();
    }
    
}
