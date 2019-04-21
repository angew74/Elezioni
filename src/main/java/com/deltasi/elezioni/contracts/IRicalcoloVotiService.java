package com.deltasi.elezioni.contracts;



import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;

import java.util.List;

public interface IRicalcoloVotiService {

    List<RicalcoloVoti> findAllBy();
    RicalcoloVoti findAllById(int id);
    void SaveAll(List<RicalcoloVoti> list);
}
