/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.model.authentication;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author AdminDSI
 */
@Entity
@Table(name = "authorities")
public class Authorities {
    
    
  @Id
  /* @Column(name = "idauthorities", columnDefinition = "NUMERIC(10,0)")*/ 
  @Column(name = "idauthorities")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
      
  
  @Column(name = "authority")
  private String authority;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id") 
  @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
  private User user;

  //Getter and Setter methods

    /**
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.id = Id;
    }
}

