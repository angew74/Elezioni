package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.UserSezione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSezioneDAO extends JpaRepository<UserSezione, Long> {

    UserSezione findById(Integer id);

    UserSezione findBySezioneAndTipoelezione(Sezione sezione, TipoElezione tipoElezione);

    UserSezione findBySezioneIdAndTipoelezioneId(Integer sezioneid, Integer idtipoelezione);

    List<UserSezione> findAllBy();

    List<UserSezione> findByUser(User user);

    List<UserSezione> findByUserIdAndTipoelezioneId(Integer userid, Integer tipoElezione);

    List<UserSezione> findByTipoelezione(TipoElezione tipoElezione);

    List<UserSezione> findByTipoelezioneIdAndUserId(Integer tipoelezioneid, Integer userid);

    List<UserSezione> findByTipoelezioneIdAndSezionePlessoId(Integer tipoelezioneid,Integer plessoid);


}
