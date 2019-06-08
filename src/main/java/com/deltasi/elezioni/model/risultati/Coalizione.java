package com.deltasi.elezioni.model.risultati;

import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "coalizioni")
public class Coalizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione tipoelezione;

    @Column(name = "denominazione")
    private String denominazione;

    @Column(name = "denominazione_breve")
    private String denominazionebreve;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sindacoid", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Sindaco sindaco;



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

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getDenominazionebreve() {
        return denominazionebreve;
    }

    public void setDenominazionebreve(String denominazionebreve) {
        this.denominazionebreve = denominazionebreve;
    }

    public Sindaco getSindaco() {
        return sindaco;
    }

    public void setSindaco(Sindaco sindaco) {
        this.sindaco = sindaco;
    }
}
