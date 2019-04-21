package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IRicalcoloVotiService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RicalcoloVotiService implements IRicalcoloVotiService {
    @Override
    public List<RicalcoloVoti> findAllBy() {
        return null;
    }

    @Override
    public RicalcoloVoti findAllById(int id) {
        return null;
    }

    @Override
    public void SaveAll(List<RicalcoloVoti> list) {

    }
}
