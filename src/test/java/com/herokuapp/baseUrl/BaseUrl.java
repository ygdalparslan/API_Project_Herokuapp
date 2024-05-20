package com.herokuapp.baseUrl;

import com.herokuapp.utilities.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.herokuapp.utilities.Authentication.generateToken;

public class BaseUrl {
    public static RequestSpecification spec;

    public static void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("baseUrl"))
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + generateToken())
                .build();
    }
}