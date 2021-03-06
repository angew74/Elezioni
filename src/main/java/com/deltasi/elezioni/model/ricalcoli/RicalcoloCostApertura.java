package com.deltasi.elezioni.model.ricalcoli;


import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Entity
@Table(name = "ricalcoli_apertura_costituzione")
public class RicalcoloCostApertura {

    public RicalcoloCostApertura()
    {

    }

    public RicalcoloCostApertura(Long numeroCostituite, Long numeroAperte)
    {
        this.numeroaperte=Integer.parseInt(numeroAperte.toString());
        this.numerocostituite= Integer.parseInt(numeroCostituite.toString());


    }

    public RicalcoloCostApertura(Long numeroCostituite, Long numeroAperte, Integer Municipio)
    {
        this.numeroaperte=Integer.parseInt(numeroAperte.toString());
        this.numerocostituite= Integer.parseInt(numeroCostituite.toString());
        this.municipio=Integer.parseInt(Municipio.toString());

    }

    public RicalcoloCostApertura(Integer numeroCostituite, Long numeroAperte)
    {
        this.numeroaperte=Integer.parseInt(numeroAperte.toString());
        this.numerocostituite= Integer.parseInt(numeroCostituite.toString());


    }

    public RicalcoloCostApertura(Long numeroCostituite, Integer numeroAperte, Integer Municipio)
    {
        this.numeroaperte=Integer.parseInt(numeroAperte.toString());
        this.numerocostituite= Integer.parseInt(numeroCostituite.toString());
        this.municipio=Integer.parseInt(Municipio.toString());

    }
    public RicalcoloCostApertura(Long numeroCostituite, Integer numeroAperte)
    {
        this.numeroaperte=Integer.parseInt(numeroAperte.toString());
        this.numerocostituite= Integer.parseInt(numeroCostituite.toString());


    }

        public RicalcoloCostApertura(Integer numeroCostituite, Long numeroAperte, int Municipio)
    {
        this.numeroaperte=Integer.parseInt(numeroAperte.toString());
        this.numerocostituite= Integer.parseInt(numeroCostituite.toString());
        this.municipio=(int)Municipio;

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione tipoelezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtiporicalcolo", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoRicalcolo tiporicalcolo;

    @Column(name = "numero_sezioni")
    private Integer numerosezioni;

    @Column(name = "numero_costituite")
    private Integer numerocostituite;

    @Column(name = "percentuale_costituite")
    private String percentualecostituite;

    @Column(name = "iscritti_totali")
    private Integer iscrittitotali;

    @Column(name = "numero_aperte")
    private Integer numeroaperte;

    @Column(name = "percentuale_aperte")
    private String percentualeaperte;

    @Column(name = "municipio")
    private Integer municipio;

    @Column(name = "utente_operazione")
    private String utenteoperazione;

    @Column(name = "data_operazione")
    private LocalDateTime dataoperazione;

    @Transient
    private Integer sezione;

    @Transient
    private String status;

    @Transient
    private Integer iscrittimaschi;

    @Transient
    private Integer iscrittifemmine;


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

    public Integer getNumerocostituite() {
        return numerocostituite;
    }

    public void setNumerocostituite(Integer numerocostituite) {
        this.numerocostituite = numerocostituite;
    }

    public Integer getNumeroaperte() {
        return numeroaperte;
    }

    public void setNumeroaperte(Integer numeroaperte) {
        this.numeroaperte = numeroaperte;
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

    public String getPercentualecostituite() {
        return percentualecostituite;
    }

    public void setPercentualecostituite(String percentualecostituite) {
        this.percentualecostituite = percentualecostituite;
    }

    public Integer getIscrittitotali() {
        return iscrittitotali;
    }

    public void setIscrittitotali(Integer iscrittitotali) {
        this.iscrittitotali = iscrittitotali;
    }

    public String getPercentualeaperte() {
        return percentualeaperte;
    }

    public void setPercentualeaperte(String percentualeaperte) {
        this.percentualeaperte = percentualeaperte;
    }

    public Integer getSezione() {
        return sezione;
    }

    public void setSezione(Integer sezione) {
        this.sezione = sezione;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
