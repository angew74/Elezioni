package com.deltasi.elezioni.model.risultati;


import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voti_lista")
public class VotiLista {


    private static final long serialVersionUID = 1L;


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotiLista)) {
            return false;
        }
        VotiLista other = (VotiLista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.deltasi.elezioni.model.risultati.VotiLista[ id=" + id + " ]";
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sezioneid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Sezione sezione;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoelezioneid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione tipoelezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listaid", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Lista lista;


   //  @ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "votiid", referencedColumnName = "id")
    private Voti voti;

    @Column(name = "municipio")
    private int municipio;

    @Column(name = "data_operazione")
    private LocalDateTime dataoperazione;

    @Column(name = "utente_operazione")
    private String  utenteoperazione;

    @Column(name = "voti")
    private Integer numerovoti;

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

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
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

    public Integer getNumerovoti() {
        return numerovoti;
    }

    public void setNumerovoti(Integer numerovoti) {
        this.numerovoti = numerovoti;
    }

    public TipoElezione getTipoelezione() {
        return tipoelezione;
    }

    public void setTipoelezione(TipoElezione tipoelezione) {
        this.tipoelezione = tipoelezione;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public Voti getVoti() {
        return voti;
    }

    public void setVoti(Voti voti) {
        this.voti = voti;
    }
}
