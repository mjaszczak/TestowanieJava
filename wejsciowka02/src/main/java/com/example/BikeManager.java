package com.example;

import java.util.ArrayList;
import java.util.List;

public class BikeManager {
    List<Bike> bikes = new ArrayList<Bike>();

    public void addBike(Bike bike){
        bikes.add(bike);
    }

    public void deleteBike(Bike bike){
        bikes.remove(bike);
    }

    public int ile(){
       return bikes.size();
    }



    /*private IMyList mylist;

    public BikeManager(IMyList mylist){
        this.mylist = mylist;
    }

    public boolean dodawanie(Bike bike){
        return mylist.add(bike);
    }

    public boolean usuwanie(Bike bike){
        return mylist.remove(bike);
    }

    public List<Bike> zapodaj(){
        return mylist.getall();
    }

    public List<Bike> findByNazwa(String nazwa){
        return mylist.findByNazwa(nazwa);
    }

    public Bike findById(long id){
        return mylist.findById(id);
    }*/
}
