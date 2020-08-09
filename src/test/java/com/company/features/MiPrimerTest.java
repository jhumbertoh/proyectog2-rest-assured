package com.company.features;

import org.junit.Test;

import static io.restassured.RestAssured.given;


public class MiPrimerTest {

    @Test
    public void miPrimerTestConRestAssured(){
        given().
           contentType("application/json").
        when().
                get("http://localhost:8081/issues.json").
        then().
                statusCode(200).log().all();
    }
}
