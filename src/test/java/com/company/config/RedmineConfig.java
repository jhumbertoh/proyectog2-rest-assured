package com.company.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class RedmineConfig {

    public static RequestSpecification requestSpecification;

    public static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void setUp(){ // http://localhost:8081/issues.json
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(RedmineEnvironments.REDMINE_LOCAL)
                .setPort(RedmineEnvironments.REDMINE_LOCAL_PORT)
                .setBasePath("/")
                .addHeader("Content-Type","application/json")
                .addHeader("X-Redmine-API-Key","f04abfe57d3828d1a53df2db5699e2d108680e0b")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        responseSpecification = new ResponseSpecBuilder()
                        .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
