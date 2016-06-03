package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import com.example.restservicedemo.domain.Guitar;
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Guitar;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;

public class GuitarServiceTest {

    private static final String GUITAR_BRAND = "Gibson";

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restservicedemo/api";
    }

    @Test
    public void addGuitars(){

       delete("/guitar/").then().assertThat().statusCode(200);

        Guitar guitar = new Guitar(GUITAR_BRAND, "Les Paul");

        given().contentType(MediaType.APPLICATION_JSON).body(guitar).when().post("/guitar/").then().assertThat().statusCode(201);

        String id = get("/guitar").path("guitar.id");

       Guitar rGuitar = given().pathParam("id", id).get("/guitar/{id}").as(Guitar.class);

        assertThat(GUITAR_BRAND, equalToIgnoringCase(rGuitar.getBrand()));
        assertEquals("Les Paul", rGuitar.getModel());
    }


}
