package com.example;

public class Bike {
    public long id;
    public String nazwa;
    public int numer_seryjny;

    public void setId(Long id) {

        this.id = id;
    }

    public void setNazwa(String nazwa) {

        this.nazwa = nazwa;
    }

    public void setNumer_seryjny(int numer_seryjny) {

        this.numer_seryjny = numer_seryjny;
    }

    public long getId() {

        return this.id = id;
    }

    public String getNazwa() {

        return this.nazwa;
    }

    public int getNumer_seryjny() {
        return this.numer_seryjny;
    }

}