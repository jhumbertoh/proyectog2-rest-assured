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

    @Test
    public void updateIssue(){

        String issueBodyJson = "{\n" +
                "  \"issue\": {\n" +
                "    \"subject\": \"Segunda modificación por José\",\n" +
                "    \"priority_id\": 5,\n" +
                "    \"notes\": \"The subject was changed\" \n" +
                "  }\n" +
                "}";

        given()
                .body(issueBodyJson).
        when()
                .put("/issues/839.json").
        then()
                .statusCode(204);
    }

    @Test
    public void deleteIssue(){

        given().
        when()
                .delete("issues/828.json").
        then()
                .statusCode(204);
    }

    @Test
    public void obtenerTodosIssuesXml(){

        given().
                contentType("application/xml").
        when()
                .get(RedmineEndpoints.LISTAR_REDMINE_ISSUES_XML).
        then()
                .statusCode(200);
    }

    @Test
    public void createNewIssueXML(){

        String issueBodyXml = "<issue>\n" +
                "    <subject>I cannot create a user.</subject>\n" +
                "    <description>As an admin user, I cannot create an user when xml...</description>\n" +
                "    <project_id>1</project_id>\n" +
                "    <tracker_id>1</tracker_id>\n" +
                "    <status_id>1</status_id>\n" +
                "    <priority_id>1</priority_id>\n" +
                "</issue>";

        given()
                .body(issueBodyXml)
                .contentType("application/xml").
        when()
                .post(RedmineEndpoints.LISTAR_REDMINE_ISSUES_XML).
        then()
                .statusCode(201);
    }

    @Test
    public void obtenerIssueXML(){

        given()
                .contentType("application/xml")
                .pathParam("idIssue", 843).
         when()
                .get(RedmineEndpoints.OBTENER_REDMINE_ISSUE_XML).
         then()
                .statusCode(200);
    }

}