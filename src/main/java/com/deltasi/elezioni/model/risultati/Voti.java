package com.deltasi.elezioni.model.risultati;

import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profilo_voti")
public class Voti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "votilistaid")
    private Integer votilistaid;

    @Column(name = "votisindacoid")
    private Integer votisindacoid;





    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sezioneid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Sezione sezione;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoelezioneid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione tipoelezione;


    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = " votigeneraliid", referencedColumnName = "id")
   //  @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private VotiGenerali votigenerali;



    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "votilistaid")
    private Set<VotiLista> votiListas = new HashSet<VotiLista>();

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "votisindacoid")
   //  @JoinColumn(name = "votisindacoid")
    private Set<VotiSindaco> votiSindacos = new HashSet<VotiSindaco>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sezione getSezione() {
        return sezione;
    }

    public void setSezione(Sezione sezione) {
        this.sezione = sezione;
    }

    public TipoElezione getTipoelezione() {
        return tipoelezione;
    }

    public void setTipoelezione(TipoElezione tipoelezione) {
        this.tipoelezione = tipoelezione;
    }

    public VotiGenerali getVotigenerali() {
        return votigenerali;
    }

    public void setVotigenerali(VotiGenerali votigenerali) {
        this.votigenerali = votigenerali;
    }

    public Set<VotiLista> getVotiListas() {
        return votiListas;
    }

    public void setVotiListas(Set<VotiLista> votiListas) {
        this.votiListas = votiListas;
    }

    public Set<VotiSindaco> getVotiSindacos() {
        return votiSindacos;
    }

    public void setVotiSindacos(Set<VotiSindaco> votiSindacos) {
        this.votiSindacos = votiSindacos;
    }

    public Integer getVotilistaid() {
        return votilistaid;
    }

    public void setVotilistaid(Integer votilistaid) {
        this.votilistaid = votilistaid;
    }

    public Integer getVotisindacoid() {
        return votisindacoid;
    }

    public void setVotisindacoid(Integer votisindacoid) {
        this.votisindacoid = votisindacoid;
    }


}
