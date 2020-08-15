package com.company.features;

import com.company.config.RedmineConfig;
import com.company.config.RedmineEndpoints;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RedmineOtherTests extends RedmineConfig {


    @Test
    public void obtenerIssueStartDate(){
//     "start_date": "2020-08-15",
        given().
                pathParam("idIssue", 840).
        when()
                .get(RedmineEndpoints.OBTENER_REDMINE_ISSUE_JSON).
        then()
                .statusCode(200)
                .body("issue.start_date",equalTo("2020-08-15"));
    }

    @Test
    public void obtenerPrimerIssueSubject(){

        given().
        when()
                .get(RedmineEndpoints.LISTAR_REDMINE_ISSUES_JSON).
        then()
                .statusCode(200)
                .body("issues[0].subject", equalTo("I cannot create a user."));
    }

    @Test
    public void obtenerTodosLosIssuesSubjects(){

        Response response =
                            given().
                            when()
                                    .get(RedmineEndpoints.LISTAR_REDMINE_ISSUES_JSON).
                            then()
                                    .statusCode(200)
                                    .extract().response();

        List<String> subjects = response.path("issues.subject");

        //Apache POI -> Manipular archivos excel
        for (String subject : subjects){
            System.out.println(subject);
        }
    }



}
