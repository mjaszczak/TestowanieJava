package com.example;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;



public class BikeSteps {

private BikeManager manager;
    private Bike bike;

    @Given("a bike")
    public void bikeSetup(){

        manager = new BikeManager();
    }

    @When("add $name bike to list")
    public void addBike(String name){
        Bike bike = new Bike(1, name, 2334);
    }

    @When("delete  $name bike from list")
    public void deleteBike(String name){
        Bike bike = new Bike(1, name, 2334);
    }

    @Then("get size should return $size")
    public void getSize(int size){
        assertEquals(size, manager.ile());
    }

    @Then("should be added $number bike")
    public void addedBike(){
        int size = manager.ile();
        manager.addBike(bike);
        assertEquals(size + 1, manager.ile());
    }

    @Then("should be deleted bike")
    public void deleteBike(){

        manager.addBike(bike);
        int size = manager.ile();
        manager.deleteBike(bike);
        assertEquals(size - 1, manager.ile());
    }





}
