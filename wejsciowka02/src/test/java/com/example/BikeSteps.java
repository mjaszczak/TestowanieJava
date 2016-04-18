package com.example;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;



public class BikeSteps {

    private Bike bike;
    BikeManager bikeManager = new BikeManager();

    @Given("a bike")
    public void bikeSetup(){
        bike = new Bike(1, "Author", 2334);
    }

    @When("add bike to list")
    public void addBike(){

        bikeManager.addBike(bike);
    }

    @When("delete bike from list")
    public void deleteBike(){


        bikeManager.deleteBike(bike);
    }

    @Then("get size should return $size")
    public void getSize(int size){
        assertEquals(size, bikeManager.ile());
    }



}
