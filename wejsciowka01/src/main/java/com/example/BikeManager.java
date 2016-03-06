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
}
