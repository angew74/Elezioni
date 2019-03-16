/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.deltasi.elezioni.model.authentication.Authorities;
import com.deltasi.elezioni.model.authentication.User;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author AdminDSI
 */
@Repository
public interface AuthorityDAO extends JpaRepository<Authorities, Integer> {

    @Override
    List<Authorities> findAll();
    List<Authorities> findAllByUser(User user);
    List<Authorities> findAllByUserUsername(String userName);
    List<User> findAllById(Integer id);
    List<User> findAllByAuthority(String Authority);
    void deleteByUserIdAndAndAuthority(Integer id, String Authority);

    
}
