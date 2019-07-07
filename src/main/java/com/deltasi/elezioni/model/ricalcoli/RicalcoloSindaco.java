package com.deltasi.elezioni.model.ricalcoli;


import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.deltasi.elezioni.model.risultati.Sindaco;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ricalcolo_voti_sindaco")
public class RicalcoloSindaco {


    public RicalcoloSindaco()
    {

    }

    public RicalcoloSindaco(Long numeroVoti, Integer idSindaco, String NomeSindacoNew, String CognomeSindacoNew, int Municipio)
    {
        super();
        this.numerovoti=Integer.parseInt(numeroVoti.toString());
        this.sindaco = new Sindaco();
        this.sindaco.setNome(NomeSindacoNew);
        this.sindaco.setCognome(CognomeSindacoNew);
        this.sindaco.setId(idSindaco);
        this.municipio = Municipio;
    }
    public RicalcoloSindaco(Long numeroVoti, Integer idSindaco, String NomeSindacoNew, String CognomeSindacoNew)
    {
        super();
        this.numerovoti=Integer.parseInt(numeroVoti.toString());
        this.sindaco = new Sindaco();
        this.sindaco.setNome(NomeSindacoNew);
        this.sindaco.setCognome(CognomeSindacoNew);
        this.sindaco.setId(idSindaco);
    }

    public RicalcoloSindaco(long numeroPervenute, int Municipio)
    {
        super();
        this.numerosezioni=(int)(numeroPervenute);
        this.municipio= Municipio;
    }

    public RicalcoloSindaco(long Votanti,long Iscritti, int Municipio)
    {
        super();
        this.iscrittipervenute=(int)(Iscritti);
        this.votantipervenute=(int) Votanti;
        this.municipio = Municipio;
    }

    public RicalcoloSindaco(long Votanti,long Iscritti)
    {
        super();
        this.iscrittipervenute=(int)(Iscritti);
        this.votantipervenute=(int) Votanti;
    }



    public RicalcoloSindaco(Long numeroPervenute)
    {
        this.numerosezioni=Integer.parseInt(numeroPervenute.toString());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoelezioneid", referencedColumnName = "id")
    @JsonIgnore
    private TipoElezione tipoelezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tiporicalcoloid", referencedColumnName = "id")
    @JsonIgnore
    private TipoRicalcolo tiporicalcolo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sindacoid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Sindaco sindaco;


    @Column(name = "numero_sezioni")
    private Integer numerosezioni;

    @Column(name = "totale_sezioni")
    private Integer totalesezioni;

    @Column(name = "municipio")
    private Integer municipio;

    @Column(name = "utente_operazione")
    private String utenteoperazione;

    @Column(name = "data_operazione")
    private LocalDateTime dataoperazione;

    @Column(name = "percentuale_sezioni_pervenute")
    private String percentualepervenute;

    @Column(name = "percentuale_voti")
    private String percentualevoti;

    @Column(name = "percentuale_votanti_pervenute")
    private String percentualevotantipervenute;

    @Column(name = "votanti_pervenute")
    private Integer votantipervenute;


    @Column(name = "percentuale_votanti_totale")
    private String percentualevotantitotale;



    @Column(name = "iscritti_totale")
    private Integer iscrittitotali;

    @Column(name = "iscritti_pervenute")
    private Integer iscrittipervenute;

    @Column(name = "numero_voti")
    private Integer numerovoti;

    @Transient
    private  Integer sezione;
    @Transient
    private  String denominazioneLista;

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

    public Sindaco getSindaco() {
        return sindaco;
    }

    public void setLista(Sindaco sindaco) {
        this.sindaco = sindaco;
    }

    public Integer getNumerosezioni() {
        return numerosezioni;
    }

    public void setNumerosezioni(Integer numerosezioni) {
        this.numerosezioni = numerosezioni;
    }

    public Integer getTotalesezioni() {
        return totalesezioni;
    }

    public void setTotalesezioni(Integer totalesezioni) {
        this.totalesezioni = totalesezioni;
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

    public String getPercentualepervenute() {
        return percentualepervenute;
    }

    public void setPercentualepervenute(String percentualepervenute) {
        this.percentualepervenute = percentualepervenute;
    }

    public String getPercentualevoti() {
        return percentualevoti;
    }

    public void setPercentualevoti(String percentualevoti) {
        this.percentualevoti = percentualevoti;
    }

    public String getPercentualevotantipervenute() {
        return percentualevotantipervenute;
    }

    public void setPercentualevotantipervenute(String percentualevotantipervenute) {
        this.percentualevotantipervenute = percentualevotantipervenute;
    }

    public String getPercentualevotantitotale() {
        return percentualevotantitotale;
    }

    public void setPercentualevotantitotale(String percentualevotantitotale) {
        this.percentualevotantitotale = percentualevotantitotale;
    }


    public Integer getIscrittitotali() {
        return iscrittitotali;
    }

    public void setIscrittitotali(Integer iscrittitotali) {
        this.iscrittitotali = iscrittitotali;
    }

    public Integer getIscrittipervenute() {
        return iscrittipervenute;
    }

    public void setIscrittipervenute(Integer iscrittipervenute) {
        this.iscrittipervenute = iscrittipervenute;
    }

    public Integer getNumerovoti() {
        return numerovoti;
    }

    public void setNumerovoti(Integer numerovoti) {
        this.numerovoti = numerovoti;
    }

    public Integer getVotantipervenute() {
        return votantipervenute;
    }

    public void setVotantipervenute(Integer votantipervenute) {
        this.votantipervenute = votantipervenute;
    }


    public Integer getSezione() {
        return sezione;
    }

    public void setSezione(Integer sezione) {
        this.sezione = sezione;
    }

    public String getDenominazioneLista() {
        return denominazioneLista;
    }

    public void setDenominazioneLista(String denominazioneLista) {
        this.denominazioneLista = denominazioneLista;
    }
}
