/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.authentication.User;
import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface IUserService {

    public void addUtente(User utente);
 
    public List<User> getAllUtenti();
 
    public void deleteUtente(Integer id);
 
    public User getUtente(int id);
 
    public User updateUtente(User utente);    
    
    public User getByUsername(String username);
    
    
}
