package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserExtendedDAO  extends JpaRepository<UserExtended, Long> {
    UserExtended findById(Integer id);
    UserExtended findByUser(User user);
    UserExtended findByUserUsername(String  userName);
    List<UserExtended> findAllBy();

}
