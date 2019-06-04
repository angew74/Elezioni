package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.UserSezione;

import java.util.List;


public interface IUserSezioneService {

     UserSezione findById(Integer id);
     UserSezione findBySezioneAndTipoelezione(Sezione sezione, TipoElezione tipoElezione);
     UserSezione findBySezioneIdAndTipoelezioneId(Integer sezioneid, Integer idtipoelezione);
     List<UserSezione> findAllBy();
     List<UserSezione> findByUser(User user);
     List<UserSezione> findByUserIdAndTipoelezioneId(Integer userid, Integer tipoElezione);
     List<UserSezione> findByTipoelezione(TipoElezione tipoElezione);
     List<UserSezione> findByTipoelezioneIdAndUserId(Integer tipoelezioneid, Integer userid);
     void SaveAll(List<UserSezione> list);
     List<UserSezione> findByTipoelezioneIdAndSezionePlessoId(Integer tipoelezioneid,Integer plessoid);
     void deleteAllBySezioneInAndUser(List<Sezione> list, User u);
}
