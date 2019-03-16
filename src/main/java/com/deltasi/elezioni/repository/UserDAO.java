/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.authentication.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdminDSI
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {


    public List<User> findAllBy();
    public void deleteById(Integer id);
    public User findById(int id);
    public User findByUsername(String username);


}
