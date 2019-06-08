/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.model.authentication;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author AdminDSI
 */
/**
 *
 * @author AdminDSI
 */

@Entity
@Table(name = "users")
public class User {

    public User() {
        this.authorities = new HashSet<>();
    }

    /**
     * @return the id
     */
    
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enaabled
     */
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return  enabled;
    }
    
     public Set<Authorities> getAuthorities() {
        return authorities;
    }
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(name = "user_name")
   @NotNull
   @Size(max = 16, min = 3, message = "{utente.username.invalido}")
   private String username;
   
   @Column(name = "password")
   @NotNull
   @Size(max = 200, min = 6, message = "{utente.password.invalido}")
   private String password;
   
   
   @Column(name = "enabled")
   @NotNull 
   private boolean enabled;
   
   
   @Column(name = "mailaziendale")
   @NotNull 
   @Email
   private String mailaziendale;
   
    @Transient
    private String roles;
   
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
  // @JsonManagedReference
  private Set<Authorities> authorities;

    /**
     * @return the mailaziendale
     */
    public String getMailaziendale() {
        return mailaziendale;
    }

    /**
     * @param mailaziendale the mailaziendale to set
     */
    public void setMailaziendale(String mailaziendale) {
        this.mailaziendale = mailaziendale;
    }

    /**
     * @return the roles
     */
    @Transient
    public String getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }



    
   
   
   
}
