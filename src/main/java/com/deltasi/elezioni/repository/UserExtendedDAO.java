package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExtendedDAO  extends JpaRepository<UserExtended, Long> {
    UserExtended findById(Integer id);
    UserExtended findByUser(User user);
    UserExtended findByUserUsername(String  userName);
    List<UserExtended> findAllBy();
    Page<UserExtended> findAllBy(Pageable pageable);

}
