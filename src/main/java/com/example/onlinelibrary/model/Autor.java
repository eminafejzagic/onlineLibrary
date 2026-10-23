package com.example.onlinelibrary.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private Long id;
    private String ime;
    private String prezime;
    private int godinaRodjenja;

    private List<Knjiga> knjige = new ArrayList<>();

    public Autor(){};

    public Autor(Long id, String ime, String prezime, int godinaRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public void setGodinaRodjenja(int godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }



    //dodajemo knjigu u listu autora
    public void dodajKnjigu(Knjiga knjiga){
        this.knjige.add(knjiga);
    }

    // treba za mapping Knjiga
    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
    }
}

