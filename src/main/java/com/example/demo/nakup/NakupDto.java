package com.example.demo.nakup;

import java.util.Date;

public class NakupDto {
    private Long id;
    private Date datum;
    private String obchod;
    private Long polozkaId;

    private String nazov;

    private Float cena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getObchod() {
        return obchod;
    }

    public void setObchod(String obchod) {
        this.obchod = obchod;
    }

    public Long getPolozkaId() {
        return polozkaId;
    }

    public void setPolozkaId(Long polozkaId) {
        this.polozkaId = polozkaId;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }
}

