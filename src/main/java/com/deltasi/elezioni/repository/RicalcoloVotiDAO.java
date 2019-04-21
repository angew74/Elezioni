package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloVotiDAO extends JpaRepository<RicalcoloVoti, Long> {

    List<RicalcoloVoti> findAllBy();
    RicalcoloVoti findAllById(int id);
    void SaveAll(List<RicalcoloVoti> list);

}
