package com.example.demo.nakup;

import com.example.demo.polozka.PolozkaEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NakupEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Date datum;

    private String obchod;

    @JoinColumn(name = "polozka_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PolozkaEntity polozka;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PolozkaEntity getPolozka() {
        return polozka;
    }

    public void setPolozka(PolozkaEntity polozka) {
        this.polozka = polozka;
    }

    public String getObchod() {
        return obchod;
    }

    public void setObchod(String obchod) {
        this.obchod = obchod;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
