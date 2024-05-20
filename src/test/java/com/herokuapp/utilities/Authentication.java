package com.herokuapp.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.herokuapp.stepDefinitions.UI_Steps.SingnUpStepDef.*;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){
        String body="{\n" +
                "    \"email\" : \""+ConfigReader.getProperty("userEmail")+"\",\n" +
                "    \"password\" : \""+ConfigReader.getProperty("userPassword")+"\"\n" +
                "}";

        Response response=given()
                .body(body)
                .contentType(ContentType.JSON)
                .when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        return response.jsonPath().getString("token");
    }
}