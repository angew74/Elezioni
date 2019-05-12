package com.deltasi.elezioni.model.ricalcoli;


import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ricalcoli_affluenza")
public class RicalcoloAffluenza {

    public RicalcoloAffluenza()
    {

    }

    public RicalcoloAffluenza(long affluenzaTotale, long affluenzaMaschi, long affluenzaFemmine, long numeroSezioni)
    {
        this.affluenzatotale=(int)affluenzaTotale;
        this.affluenzamaschi=(int)affluenzaMaschi;
        this.affluenzafemmine=(int)affluenzaFemmine;
        this.numerosezioni=(int)numeroSezioni;

    }



    public RicalcoloAffluenza(long affluenzaTotale, long affluenzaMaschi, long affluenzaFemmine, int Municipio,long numeroSezioni)
    {
        this.affluenzatotale=(int)affluenzaTotale;
        this.affluenzamaschi=(int)affluenzaMaschi;
        this.affluenzafemmine=(int)affluenzaFemmine;
        this.numerosezioni=(int)numeroSezioni;
        this.municipio=(int)Municipio;

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
    @JsonIgnore
    private TipoElezione tipoelezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtiporicalcolo", referencedColumnName = "id")
    @JsonIgnore
    private TipoRicalcolo tiporicalcolo;

    @Column(name = "numero_sezioni")
    private Integer numerosezioni;

    @Column(name = "totale_sezioni")
    private Integer totalesezioni;

    @Column(name = "numero_affluenza")
    private Integer numeroaffluenza;

    @Column(name = "affluenza_totale")
    private Integer affluenzatotale;

    @Column(name = "affluenza_maschi")
    private Integer affluenzamaschi;

    @Column(name = "affluenza_femmine")
    private Integer affluenzafemmine;

    @Column(name = "percentuale_totale")
    private String percentualetotale;

    @Column(name = "iscritti_maschi")
    private Integer iscrittimaschi;

    @Column(name = "iscritti_femmine")
    private Integer iscrittifemmine;

    @Column(name = "percentuale_maschi")
    private String percentualemaschi;

    @Column(name = "percentuale_femmine")
    private String percentualefemmine;

    @Column(name = "municipio")
    private Integer municipio;

    @Column(name = "utente_operazione")
    private String utenteoperazione;

    @Column(name = "data_operazione")
    private LocalDateTime dataoperazione;

    @Column(name = "percentuale_sezioni_pervenute")
    private String percentualepervenute;

    @Column(name = "iscritti_totale")
    private Integer iscrittitotali;

    @Transient
    private Integer sezione;


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

    public TipoRicalcolo getTiporicalcolo() {
        return tiporicalcolo;
    }

    public void setTiporicalcolo(TipoRicalcolo tiporicalcolo) {
        this.tiporicalcolo = tiporicalcolo;
    }

    public Integer getNumerosezioni() {
        return numerosezioni;
    }

    public void setNumerosezioni(Integer numerosezioni) {
        this.numerosezioni = numerosezioni;
    }

    public Integer getNumeroaffluenza() {
        return numeroaffluenza;
    }

    public void setNumeroaffluenza(Integer numeroaffluenza) {
        this.numeroaffluenza = numeroaffluenza;
    }

    public Integer getAffluenzatotale() {
        return affluenzatotale;
    }

    public void setAffluenzatotale(Integer affluenzatotale) {
        this.affluenzatotale = affluenzatotale;
    }

    public Integer getAffluenzamaschi() {
        return affluenzamaschi;
    }

    public void setAffluenzamaschi(Integer affluenzamaschi) {
        this.affluenzamaschi = affluenzamaschi;
    }

    public Integer getAffluenzafemmine() {
        return affluenzafemmine;
    }

    public void setAffluenzafemmine(Integer affluenzafemmine) {
        this.affluenzafemmine = affluenzafemmine;
    }

    public String getPercentualetotale() {
        return percentualetotale;
    }

    public void setPercentualetotale(String percentualetotale) {
        this.percentualetotale = percentualetotale;
    }

    public String getPercentualemaschi() {
        return percentualemaschi;
    }

    public void setPercentualemaschi(String percentualemaschi) {
        this.percentualemaschi = percentualemaschi;
    }

    public String getPercentualefemmine() {
        return percentualefemmine;
    }

    public void setPercentualefemmine(String percentualefemmine) {
        this.percentualefemmine = percentualefemmine;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public String getUtenteoperazione() {
        return utenteoperazione;
    }

    public void setUtenteoperazione(String utenteoperazione) {
        this.utenteoperazione = utenteoperazione;
    }

    public LocalDateTime getDataoperazione() {
        return dataoperazione;
    }

    public void setDataoperazione(LocalDateTime dataoperazione) {
        this.dataoperazione = dataoperazione;
    }

    public Integer getTotalesezioni() {
        return totalesezioni;
    }

    public void setTotalesezioni(Integer totalesezioni) {
        this.totalesezioni = totalesezioni;
    }

    public String getPercentualepervenute() {
        return percentualepervenute;
    }

    public void setPercentualepervenute(String percentualepervenute) {
        this.percentualepervenute = percentualepervenute;
    }

    public Integer getIscrittimaschi() {
        return iscrittimaschi;
    }

    public void setIscrittimaschi(Integer iscrittimaschi) {
        this.iscrittimaschi = iscrittimaschi;
    }

    public Integer getIscrittifemmine() {
        return iscrittifemmine;
    }

    public void setIscrittifemmine(Integer iscrittifemmine) {
        this.iscrittifemmine = iscrittifemmine;
    }

    public Integer getIscrittitotali() {
        return iscrittitotali;
    }

    public void setIscrittitotali(Integer iscrittitotali) {
        this.iscrittitotali = iscrittitotali;
    }

    public Integer getSezione() {
        return sezione;
    }

    public void setSezione(Integer sezione) {
        this.sezione = sezione;
    }
}
