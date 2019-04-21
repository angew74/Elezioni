package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AffluenzaDAO extends JpaRepository<Affluenza, Long> {

    Affluenza findById(Integer id);
    Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneId(Integer sezione, Integer tipoElezioneId);
    Affluenza findBySezioneId(Integer idsezione);
    List<Affluenza> findByPlessoId(Integer idplesso);
    List<Affluenza> findByPlessoMunicipio(Integer municipio);
    List<Affluenza> findByPlesso(Plesso plesso);
    List<Affluenza> findByTipoelezione(TipoElezione tipoElezione);
    List<Affluenza> findByTipoelezioneId(Integer idTipoElezione);
    Affluenza findBySezioneNumerosezioneAndTipoelezioneId(int numero,int tipoElezioneId);
    List<Affluenza> findByApertura1AndTipoelezioneId(int a, int tipoElezioneId);
    List<Affluenza> findByApertura2AndTipoelezioneId(int a,int tipoElezioneId);
    List<Affluenza> findByApertura3AndTipoelezioneId(int a,int tipoElezioneId);
    List<Affluenza> findByCostituzione1AndTipoelezioneId(int c,int tipoElezioneId);
    List<Affluenza> findByCostituzione2AndTipoelezioneId(int c,int tipoElezioneId);
    List<Affluenza> findByAffluenza1AndTipoelezioneId(int a,int tipoElezioneId);
    List<Affluenza> findByAffluenza2AndTipoelezioneId(int a,int tipoElezioneId);
    List<Affluenza> findByAffluenza3AndTipoelezioneId(int a,int tipoElezioneId);
    List<Affluenza> findByAffluenza4AndTipoelezioneId(int a,int tipoElezioneId);
    List<Affluenza> findByAffluenza5AndTipoelezioneId(int a,int tipoElezioneId);
    /* interrogazioni per sezione */
    List<Affluenza> findByAffluenza1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);
    List<Affluenza> findByAffluenza2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);
    List<Affluenza> findByAffluenza3AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);
    List<Affluenza> findByCostituzione1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);
    List<Affluenza> findByCostituzione2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);
    List<Affluenza> findByApertura1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);
    List<Affluenza> findByApertura2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);
    /* interrogazione per Municipio*/
    List<Affluenza> findByAffluenza1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);
    List<Affluenza> findByAffluenza2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);
    List<Affluenza> findByAffluenza3AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);
    List<Affluenza> findByCostituzione1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);
    List<Affluenza> findByCostituzione2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);
    List<Affluenza> findByApertura1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);
    List<Affluenza> findByApertura2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);
   // List<Integer> countAffluenzaByVotantifemmine1AndVotantimaschi1AndVotantitotali1();

    /* count per tipologia e municpio con ricerca per pervenute e non  */
    List<Integer> countByAffluenza1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByAffluenza2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByAffluenza3AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    /* count per sola tipologia */
    List<Long> countByAffluenza1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Long> countByAffluenza2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Long> countByAffluenza3AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    /* count per tipologia e plesso */
    @Modifying
    @Query("select new RicalcoloAffluenza(a.votantitotali1 as affluenzatotale, a.votantimaschi1 as affluenzamaschi, a.votantifemmine1 as affluenzafemmine," +
            " count(*) as numerosezioni) " +
            " from Affluenza a where a.affluenza1=1 and a.tipoelezione.id=?1 group by a.affluenza1")
    List<RicalcoloAffluenza> countAffluenza1(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloAffluenza(a.votantitotali1 as affluenzatotale, a.votantimaschi1 as affluenzamaschi, a.votantifemmine1 as affluenzafemmine," +
            " count(*) as numerosezioni) " +
            " from Affluenza a where a.affluenza2=1 and a.tipoelezione.id=?1 group by a.affluenza1")
    List<RicalcoloAffluenza> countAffluenza2(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloAffluenza(a.votantitotali1 as affluenzatotale, a.votantimaschi1 as affluenzamaschi, a.votantifemmine1 as affluenzafemmine," +
            " count(*) as numerosezioni) " +
            " from Affluenza a where a.affluenza3=1 and a.tipoelezione.id=?1 group by a.affluenza1")
    List<RicalcoloAffluenza> countAffluenza3(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloAffluenza(a.votantitotali1 as affluenzatotale, a.votantimaschi1 as affluenzamaschi, a.votantifemmine1 as affluenzafemmine, " +
            "s.municipio as municipio, count(*) " +
            "as numerosezioni) " +
            " from Affluenza a inner join Sezione s on a.sezione.id=s.id" +
            " where a.affluenza1=1 and a.tipoelezione.id=?1 " +
            " group by s.municipio")
    List<RicalcoloAffluenza> countAffluenza1ByMunicipio(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloAffluenza(a.votantitotali1 as affluenzatotale, a.votantimaschi1 as affluenzamaschi, a.votantifemmine1 as affluenzafemmine, " +
            "s.municipio as municipio, count(*) " +
            "as numerosezioni) " +
            " from Affluenza a inner join Sezione s on a.sezione.id=s.id" +
            " where a.affluenza2=1 and a.tipoelezione.id=?1 " +
            " group by s.municipio")
    List<RicalcoloAffluenza> countAffluenza2ByMunicipio(int tipoelezioneid);
    @Modifying
    @Query("select new RicalcoloAffluenza(a.votantitotali1 as affluenzatotale, a.votantimaschi1 as affluenzamaschi, a.votantifemmine1 as affluenzafemmine, " +
            "s.municipio as municipio, count(*) " +
            "as numerosezioni) " +
            " from Affluenza a inner join Sezione s on a.sezione.id=s.id" +
            " where a.affluenza3=1 and a.tipoelezione.id=?1 " +
            " group by s.municipio")
    List<RicalcoloAffluenza> countAffluenza3ByMunicipio(int tipoelezioneid);


    @Modifying
    @Query("select new RicalcoloCostApertura(0 as numeroCostituite, count(*) as numeroAperte) from Affluenza a where a.apertura1=?1")
    List<RicalcoloCostApertura> countApertura1(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloCostApertura(0 as numeroCostituite, count(*) as numeroAperte) from Affluenza a where a.apertura2=?1")
    List<RicalcoloCostApertura> countApertura2(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloCostApertura(count(*) as numeroCostituite, 0 as numeroAperte) from Affluenza a where a.costituzione1=?1")
    List<RicalcoloCostApertura> countCostituzione1(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloCostApertura(count(*) as numerocostituite, 0 as numeroAperte) from Affluenza a where a.costituzione2=?1")
    List<RicalcoloCostApertura> countCostituzione2(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloCostApertura(0 as numeroCostituite, count(*) as numeroaperte, s.municipio as municipio) from Affluenza a " +
           " inner join Sezione s on a.sezione.id=s.id" +
            " where a.apertura1=1 and a.tipoelezione.id=?1 " +
            "group by s.municipio")
    List<RicalcoloCostApertura> countApertura1ByMunicipio(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloCostApertura(0 as numeroCostituite, count(*) as numeroaperte, s.municipio as municipio) from Affluenza a " +
            " inner join Sezione s on a.sezione.id=s.id" +
            " where a.apertura2=1 and a.tipoelezione.id=?1 " +
            "group by s.municipio")
    List<RicalcoloCostApertura> countApertura2ByMunicipio(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloCostApertura(count(*) as numerocostituite, 0 as numeroAperte, s.municipio as municipio) from Affluenza a " +
            " inner join Sezione s on a.sezione.id=s.id" +
            " where a.costituzione1=1 and a.tipoelezione.id=?1 " +
            "group by s.municipio")
    List<RicalcoloCostApertura> countCostituzione1ByMunicipio(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloCostApertura(count(*) as numerocostituite, 0 as numeroAperte, s.municipio as municipio) from Affluenza a " +
            " inner join Sezione s on a.sezione.id=s.id" +
            " where a.costituzione2=1 and a.tipoelezione.id=?1 " +
            "group by s.municipio")
    List<RicalcoloCostApertura> countCostituzione2ByMunicipio(int tipoelezioneid);



}
