/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.authentication.Authorities;
import com.deltasi.elezioni.model.authentication.User;
import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface IAuthorityService {
    public void addUtenteToAuthority(Authorities authority);
 
    public List<User> getAllUtentiByAuthority(String authority);
 
    public void removeUtenteFromAuthoriy(Integer iduser, String authority);
 
    public List<Authorities> getAuthorityByUtente(String UserName);
 
   
    
}
