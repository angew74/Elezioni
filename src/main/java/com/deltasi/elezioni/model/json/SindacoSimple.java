package com.deltasi.elezioni.model.json;

import java.util.List;

public class SindacoSimple {


    private Integer voti;
    private Integer solosindaco;
    private Integer numerosezione;
    private Integer idsindaco;
    private String tipo;
    private String nome;
    private  String cognome;
    private Integer id;
    private List<ListaSemplice> liste;
    private String iscoalizione;

    public Integer getVoti() {
        return voti;
    }

    public void setVoti(Integer voti) {
        this.voti = voti;
    }

    public Integer getNumerosezione() {
        return numerosezione;
    }

    public void setNumerosezione(Integer numerosezione) {
        this.numerosezione = numerosezione;
    }

    public Integer getIdsindaco() {
        return idsindaco;
    }

    public void setIdsindaco(Integer idsindaco) {
        this.idsindaco = idsindaco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<ListaSemplice> getListe() {
        return liste;
    }

    public void setListe(List<ListaSemplice> liste) {
        this.liste = liste;
    }

    public String getIscoalizione() {
        return iscoalizione;
    }

    public void setIscoalizione(String iscoalizione) {
        this.iscoalizione = iscoalizione;
    }


    public Integer getSolosindaco() {
        return solosindaco;
    }

    public void setSolosindaco(Integer solosindaco) {
        this.solosindaco = solosindaco;
    }
}
