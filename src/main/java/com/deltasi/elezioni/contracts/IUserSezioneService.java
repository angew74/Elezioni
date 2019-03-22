package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.UserSezione;

import java.util.List;

public interface IUserSezioneService {

    public UserSezione findById(Integer id);
    public UserSezione findBySezioneAndTipoelezione(Sezione sezione, TipoElezione tipoElezione);
    public UserSezione findBySezioneIdAndTipoelezioneId(Integer sezioneid, Integer idtipoelezione);
    public List<UserSezione> findAllBy();
    public List<UserSezione> findByUser(User user);
    public List<UserSezione> findByUserIdAndTipoelezioneId(Integer userid, Integer tipoElezione);
    public List<UserSezione> findByTipoelezione(TipoElezione tipoElezione);
    public List<UserSezione> findByTipoelezioneIdAndUserId(Integer tipoelezioneid, Integer userid);
}
