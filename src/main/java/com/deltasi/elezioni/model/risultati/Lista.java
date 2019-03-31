package com.deltasi.elezioni.model.risultati;


import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "liste")
public class Lista {

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

    @Column(name = "progressivo")
    private Integer progressivo;

    @Column(name = "progressivo_manifesto")
    private Integer progressivomanifesto;

    @Column(name = "progressivo_coalizione")
    private Integer progressivocoalizione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcoalizione", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Coalizione coalizione;

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

    public Coalizione getCoalizione() {
        return coalizione;
    }

    public void setCoalizione(Coalizione coalizione) {
        this.coalizione = coalizione;
    }

    public Integer getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(Integer progressivo) {
        this.progressivo = progressivo;
    }

    public Integer getProgressivomanifesto() {
        return progressivomanifesto;
    }

    public void setProgressivomanifesto(Integer progressivomanifesto) {
        this.progressivomanifesto = progressivomanifesto;
    }

    public Integer getProgressivocoalizione() {
        return progressivocoalizione;
    }

    public void setProgressivocoalizione(Integer progressivocoalizione) {
        this.progressivocoalizione = progressivocoalizione;
    }
}
