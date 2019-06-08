package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserExtendedService {

    UserExtended findById(Integer id);
    public UserExtended findByUser(User user);
    UserExtended findByUserUsername(String userName);
    List<UserExtended> findAll();
    Page<UserExtended> findAll(Pageable pageable);
    void addUtente(UserExtended utente);
    UserExtended updateUtente(UserExtended utente);
}
