package com.example.restservicedemo;

import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import com.example.restservicedemo.domain.Guitar;
import com.example.restservicedemo.service.GuitarManager;
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;


import javax.ws.rs.core.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;



public class GuitarServiceTest {

    private GuitarManager gm = new GuitarManager();

    private static final Long GUITAR_ID = 1L;
    private static final String GUITAR_BRAND = "Gibson";
    private static final String GUITAR_MODEL = "Les Paul";

    private static final Long GUITAR2_ID = 2L;
    private static final String GUITAR2_BRAND = "Fender";
    private static final String GUITAR2_MODEL = "Telecaster";

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restservicedemo/api";
    }


    @Test
    public void addGuitar(){

      delete("/guitar/").then().assertThat().statusCode(200);

        Guitar guitar = new Guitar(GUITAR_ID , GUITAR_BRAND, GUITAR_MODEL);

        given().contentType(MediaType.APPLICATION_JSON).body(guitar).when().post("/guitar/").then().assertThat().statusCode(201);

        Guitar rGuitar = get("/guitar/1").as(Guitar.class);

        assertThat(GUITAR_BRAND, equalToIgnoringCase(rGuitar.getBrand()));
        assertThat(GUITAR_MODEL, equalToIgnoringCase(rGuitar.getModel()));


    }

    @Test
    public void getAllGuitars() {
        String guitars = get("/guitar/all/").asString();


        delete("/guitar/").then().assertThat().statusCode(200);

        Guitar guitar = new Guitar(GUITAR_ID , GUITAR_BRAND, GUITAR_MODEL);
        Guitar guitar2 = new Guitar(GUITAR2_ID , GUITAR2_BRAND, GUITAR2_MODEL);


        given().contentType(MediaType.APPLICATION_JSON).body(guitar).when().post("/guitar/").then().assertThat().statusCode(201);
        given().contentType(MediaType.APPLICATION_JSON).body(guitar2).when().post("/guitar/").then().assertThat().statusCode(201);


        Guitar rGuitar = get("/guitar/1").as(Guitar.class);
        Guitar rGuitar2 = get("/guitar/2").as(Guitar.class);


        assertThat(GUITAR_BRAND, equalToIgnoringCase(rGuitar.getBrand()));
        assertThat(GUITAR2_BRAND, equalToIgnoringCase(rGuitar2.getBrand()));

    }

    @Test
    public void deleteAllGuitars(){
        String guitars = get("/guitar/all/").asString();
        assertNull(guitars, null);


        delete("/guitar/").then().assertThat().statusCode(200);

        Guitar guitar = new Guitar(GUITAR_ID , GUITAR_BRAND, GUITAR_MODEL);
        Guitar guitar2 = new Guitar(GUITAR2_ID , GUITAR2_BRAND, GUITAR2_MODEL);


        given().contentType(MediaType.APPLICATION_JSON).body(guitar).when().post("/guitar/").then().assertThat().statusCode(201);
        given().contentType(MediaType.APPLICATION_JSON).body(guitar2).when().post("/guitar/").then().assertThat().statusCode(201);

        Guitar rGuitar = get("/guitar/1").as(Guitar.class);
        Guitar rGuitar2 = get("/guitar/2").as(Guitar.class);



        guitars = get("/guitar/all/").asString();

        gm.clearGuitars();
        assertNull(guitars, null);


    }

    @Test
    public void updateGuitar(){
        delete("/guitar/").then().assertThat().statusCode(200);

        Guitar guitar = new Guitar(GUITAR_ID , GUITAR_BRAND, GUITAR_MODEL);

        given().contentType(MediaType.APPLICATION_JSON).body(guitar).when().post("/guitar/").then().assertThat().statusCode(201);

        Guitar rGuitar = get("/guitar/1").as(Guitar.class);

        assertThat(GUITAR_BRAND, equalToIgnoringCase(rGuitar.getBrand()));
        assertThat(GUITAR_MODEL, equalToIgnoringCase(rGuitar.getModel()));

        given().contentType(MediaType.APPLICATION_JSON).body(guitar).when().post("/guitar/1").then().assertThat().statusCode(200);



        rGuitar = get("/guitar/1").as(Guitar.class);

        assertThat("Czibson", equalToIgnoringCase(rGuitar.getBrand()));

        /*gm.updateGuitar(guitar, "Czibson", "Dres Paul");

        rGuitar = get("/guitar/1").as(Guitar.class);

        assertThat("Czibson", equalToIgnoringCase(rGuitar.getBrand()));
        assertThat("Dres Paul", equalToIgnoringCase(rGuitar.getModel()));*/

    }

}
