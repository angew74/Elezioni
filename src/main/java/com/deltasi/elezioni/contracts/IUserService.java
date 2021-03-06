/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.authentication.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface IUserService {

    void addUtente(User utente);
 
    List<User> getAllUtenti();

    Page<User> findAll(PageRequest pageable);
 
    void deleteUtente(Integer id);
 
    User getUtente(int id);
 
    User updateUtente(User utente);
    
    User getByUsername(String username);

    List<User> getByUserNameLike(String username);
    
    
}
