package com.example;

import java.util.List;

public interface IMyList {
    boolean add(Bike bike);
    boolean remove(Bike bike);
    List<Bike> getall();
}
