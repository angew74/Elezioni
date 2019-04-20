package com.deltasi.elezioni.model.risultati;


import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "affluenze")
public class Affluenza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione tipoelezione;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idsezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Sezione sezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idplesso", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Plesso plesso;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idiscritti", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Iscritti iscritti;

    @Column(name = "costituzione1")
    private Integer costituzione1;

    @Column(name = "costituzione2")
    private Integer costituzione2;

    @Column(name = "apertura1")
    private Integer apertura1;

    @Column(name = "apertura2")
    private Integer apertura2;

    @Column(name = "apertura3")
    private Integer apertura3;

    @Column(name = "affluenza1")
    private Integer affluenza1;

    @Column(name = "affluenza2")
    private Integer affluenza2;

    @Column(name = "affluenza3")
    private Integer affluenza3;

    @Column(name = "affluenza4")
    private Integer affluenza4;

    @Column(name = "affluenza5")
    private Integer affluenza5;

    @Column(name = "votantimaschi1")
    private Integer votantimaschi1;


    @Column(name = "votantimaschi2")
    private Integer votantimaschi2;

    @Column(name = "votantimaschi3")
    private Integer votantimaschi3;

    @Column(name = "votantimaschi4")
    private Integer votantimaschi4;

    @Column(name = "votantimaschi5")
    private Integer votantimaschi5;

    @Column(name = "votantifemmine1")
    private Integer votantifemmine1;

    @Column(name = "votantifemmine2")
    private Integer votantifemmine2;

    @Column(name = "votantifemmine3")
    private Integer votantifemmine3;

    @Column(name = "votantifemmine4")
    private Integer votantifemmine4;

    @Column(name = "votantifemmine5")
    private Integer votantifemmine5;

    @Column(name = "votantitotali1")
    private Integer votantitotali1;

    @Column(name = "votantitotali2")
    private Integer votantitotali2;

    @Column(name = "votantitotali3")
    private Integer votantitotali3;

    @Column(name = "votantitotali4")
    private Integer votantitotali4;

    @Column(name = "votantitotali5")
    private Integer votantitotali5;

    @Column(name = "dataoperazione")
    private LocalDateTime dataoperazione;

    @Column(name = "utenteoperazione")
    private String  utenteoperazione;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoElezione getTipoelezione() {
        return tipoelezione;
    }

    public void setTipoelezione(TipoElezione tipoelezione) {
        this.tipoelezione = tipoelezione;
    }

    public Plesso getPlesso() {
        return plesso;
    }

    public void setPlesso(Plesso plesso) {
        this.plesso = plesso;
    }

    public Iscritti getIscritti() {
        return iscritti;
    }

    public void setIscritti(Iscritti iscritti) {
        this.iscritti = iscritti;
    }


    public Integer getApertura1() {
        return apertura1;
    }

    public void setApertura1(Integer apertura1) {
        this.apertura1 = apertura1;
    }

    public Integer getApertura2() {
        return apertura2;
    }

    public void setApertura2(Integer apertura2) {
        this.apertura2 = apertura2;
    }

    public Integer getApertura3() {
        return apertura3;
    }

    public void setApertura3(Integer apertura3) {
        this.apertura3 = apertura3;
    }

    public Integer getVotantimaschi1() {
        return votantimaschi1;
    }

    public void setVotantimaschi1(Integer votantimaschi1) {
        this.votantimaschi1 = votantimaschi1;
    }

    public Integer getVotantimaschi2() {
        return votantimaschi2;
    }

    public void setVotantimaschi2(Integer votantimaschi2) {
        this.votantimaschi2 = votantimaschi2;
    }

    public Integer getVotantimaschi3() {
        return votantimaschi3;
    }

    public void setVotantimaschi3(Integer votantimaschi3) {
        this.votantimaschi3 = votantimaschi3;
    }

    public Integer getVotantimaschi4() {
        return votantimaschi4;
    }

    public void setVotantimaschi4(Integer votantimaschi4) {
        this.votantimaschi4 = votantimaschi4;
    }

    public Integer getVotantimaschi5() {
        return votantimaschi5;
    }

    public void setVotantimaschi5(Integer votantimaschi5) {
        this.votantimaschi5 = votantimaschi5;
    }

    public Integer getVotantifemmine1() {
        return votantifemmine1;
    }

    public void setVotantifemmine1(Integer votantifemmine1) {
        this.votantifemmine1 = votantifemmine1;
    }

    public Integer getVotantifemmine2() {
        return votantifemmine2;
    }

    public void setVotantifemmine2(Integer votantifemmine2) {
        this.votantifemmine2 = votantifemmine2;
    }

    public Integer getVotantifemmine3() {
        return votantifemmine3;
    }

    public void setVotantifemmine3(Integer votantifemmine3) {
        this.votantifemmine3 = votantifemmine3;
    }

    public Integer getVotantifemmine4() {
        return votantifemmine4;
    }

    public void setVotantifemmine4(Integer votantifemmine4) {
        this.votantifemmine4 = votantifemmine4;
    }

    public Integer getVotantifemmine5() {
        return votantifemmine5;
    }

    public void setVotantifemmine5(Integer votantifemmine5) {
        this.votantifemmine5 = votantifemmine5;
    }

    public Integer getVotantitotali1() {
        return votantitotali1;
    }

    public void setVotantitotali1(Integer votantitotali1) {
        this.votantitotali1 = votantitotali1;
    }

    public Integer getVotantitotali2() {
        return votantitotali2;
    }

    public void setVotantitotali2(Integer votantitotali2) {
        this.votantitotali2 = votantitotali2;
    }

    public Integer getVotantitotali3() {
        return votantitotali3;
    }

    public void setVotantitotali3(Integer votantitotali3) {
        this.votantitotali3 = votantitotali3;
    }

    public Integer getVotantitotali4() {
        return votantitotali4;
    }

    public void setVotantitotali4(Integer votantitotali4) {
        this.votantitotali4 = votantitotali4;
    }

    public Integer getVotantitotali5() {
        return votantitotali5;
    }

    public void setVotantitotali5(Integer votantitotali5) {
        this.votantitotali5 = votantitotali5;
    }

    public LocalDateTime getDataoperazione() {
        return dataoperazione;
    }

    public void setDataoperazione(LocalDateTime dataoperazione) {
        this.dataoperazione = dataoperazione;
    }

    public String getUtenteoperazione() {
        return utenteoperazione;
    }

    public void setUtenteoperazione(String utenteoperazione) {
        this.utenteoperazione = utenteoperazione;
    }

    public Integer getCostituzione1() {
        return costituzione1;
    }

    public void setCostituzione1(Integer costituzione1) {
        this.costituzione1 = costituzione1;
    }

    public Integer getCostituzione2() {
        return costituzione2;
    }

    public void setCostituzione2(Integer costituzione2) {
        this.costituzione2 = costituzione2;
    }

    public Integer getAffluenza1() {
        return affluenza1;
    }

    public void setAffluenza1(Integer affluenza1) {
        this.affluenza1 = affluenza1;
    }

    public Integer getAffluenza2() {
        return affluenza2;
    }

    public void setAffluenza2(Integer affluenza2) {
        this.affluenza2 = affluenza2;
    }

    public Integer getAffluenza3() {
        return affluenza3;
    }

    public void setAffluenza3(Integer affluenza3) {
        this.affluenza3 = affluenza3;
    }

    public Integer getAffluenza4() {
        return affluenza4;
    }

    public void setAffluenza4(Integer affluenza4) {
        this.affluenza4 = affluenza4;
    }

    public Integer getAffluenza5() {
        return affluenza5;
    }

    public void setAffluenza5(Integer affluenza5) {
        this.affluenza5 = affluenza5;
    }

    public Sezione getSezione() {
        return sezione;
    }

    public void setSezione(Sezione sezione) {
        this.sezione = sezione;
    }
}
