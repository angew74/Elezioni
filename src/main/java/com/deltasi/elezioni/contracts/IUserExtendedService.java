package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;

import java.util.List;

public interface IUserExtendedService {

    UserExtended findById(Integer id);
    public UserExtended findByUser(User user);
    UserExtended findByUserUsername(String userName);
    List<UserExtended> findAll();
    void addUtente(UserExtended utente);
    UserExtended updateUtente(UserExtended utente);
}
