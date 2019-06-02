package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IUserSezioneService;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.UserSezione;
import com.deltasi.elezioni.repository.UserSezioneDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSezioneService implements IUserSezioneService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserSezioneDAO userSezioneDAO;


    @Override
    public void SaveAll(List<UserSezione> list) {
        userSezioneDAO.saveAll(list);
    }

    public UserSezione findById(Integer id)
    {
        return  userSezioneDAO.findById(id);
    }
    public UserSezione findBySezioneAndTipoelezione(Sezione sezione, TipoElezione tipoElezione)
    {
        return userSezioneDAO.findBySezioneAndTipoelezione(sezione, tipoElezione);
    }
    public UserSezione findBySezioneIdAndTipoelezioneId(Integer sezioneid, Integer idtipoelezione)
    {
        return  userSezioneDAO.findBySezioneIdAndTipoelezioneId(sezioneid,idtipoelezione);
    }
    public List<UserSezione> findAllBy()
    {
        return userSezioneDAO.findAllBy();
    }

    public void Save(UserSezione userSezione)
    {
        userSezioneDAO.save(userSezione);
    }

    public void Delete(UserSezione userSezione)
    {
        userSezioneDAO.delete(userSezione);
    }

    public  void DeleteById(Long id)
    {
        userSezioneDAO.deleteById(id);
    }

    public List<UserSezione> findByUser(User user)
    {
        return  userSezioneDAO.findByUser(user);
    }
    public List<UserSezione> findByUserIdAndTipoelezioneId(Integer userid, Integer tipoElezioneid)
    {
        return  userSezioneDAO.findByUserIdAndTipoelezioneId(userid, tipoElezioneid);
    }
    public List<UserSezione> findByTipoelezione(TipoElezione tipoElezione)
    {
        return  userSezioneDAO.findByTipoelezione(tipoElezione);
    }
    public List<UserSezione> findByTipoelezioneIdAndUserId(Integer tipoelezioneid, Integer userid)
    {
        return  userSezioneDAO.findByTipoelezioneIdAndUserId(tipoelezioneid,userid);
    }

    public   List<UserSezione> findByTipoelezioneIdAndSezionePlessoId(Integer tipoelezioneid,Integer plessoid)
    {
        return userSezioneDAO.findByTipoelezioneIdAndSezionePlessoId(tipoelezioneid,plessoid);
    }

}
