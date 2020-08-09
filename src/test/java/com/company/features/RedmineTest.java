package com.company.features;

import com.company.config.RedmineConfig;
import com.company.config.RedmineEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RedmineTest extends RedmineConfig {

    @Test
    public void crearNuevoIssueJson(){

        String issueBody ="{\n" +
                "  \"issue\": {\n" +
                "    \"project_id\": 1,\n" +
                "    \"subject\": \"Mi primer issue creado desde rest assured\",\n" +
                "    \"priority_id\": 1\n" +
                "  }\n" +
                "}";

        given()
                .body(issueBody).
        when()
                .post(RedmineEndpoints.LISTAR_REDMINE_ISSUES_JSON).
        then()
                .statusCode(201);
    }

    @Test
    public void obtenerUnIssueJson(){

        given()
                .pathParam("idIssue", 21).
        when()
                .get(RedmineEndpoints.OBTENER_REDMINE_ISSUE_JSON).
        then()
                .statusCode(200);

    }
}