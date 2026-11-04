package com.example.onlinelibrary.model;

import jakarta.persistence.*;

@Entity
@Table(name = "knjiga")
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naslov;
    private String zanr;
    private int godinaIzdanja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Clan clan;

    public Knjiga(){}

    public Knjiga(Long id, String naslov, String zanr, int godinaIzdanja, Autor autor) {
        this.id = id;
        this.naslov = naslov;
        this.zanr = zanr;
        this.godinaIzdanja = godinaIzdanja;
        this.autor = autor;
    }
    public Knjiga(Long id, String naslov, String zanr, int godinaIzdanja) {
        this.id = id;
        this.naslov = naslov;
        this.zanr = zanr;
        this.godinaIzdanja = godinaIzdanja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}

