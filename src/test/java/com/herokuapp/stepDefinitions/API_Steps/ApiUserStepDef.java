package com.herokuapp.stepDefinitions.API_Steps;

import com.herokuapp.pojos.UserPojo;
import com.herokuapp.pojos.UserRootPojo;
import com.herokuapp.pojos.UserSignUpPojo;
import com.herokuapp.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static com.herokuapp.baseUrl.BaseUrl.spec;
import static com.herokuapp.utilities.ReusableMethods.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class ApiUserStepDef {

    UserSignUpPojo payLoad;
    Response response;
    UserRootPojo actualData;
    UserPojo expectedData;

    @Given("{string} icin URL duzenlenir")
    public void icinURLDuzenlenir(String param) {
        switch (param) {
            case "Add User" -> spec.pathParams("first", "users");
            case "Get User" -> spec.pathParams("first", "users", "second", "me");
            case "Update User" -> spec.pathParams("first", "users", "second", "me");
            case "Log Out User" -> spec.pathParams("first", "users", "second", "logout");
        }
    }

    @And("{string} icin Payload duzenlenir")
    public void icinPayloadDuzenlenir(String payload) {
        switch (payload) {
            case "Add User" ->
                    payLoad = new UserSignUpPojo(firstNameCreator(), lastNameCreator(), emailCreator(), passwordCreator());
            case "Update User" ->
                    payLoad = new UserSignUpPojo("Alparslan", "Yigid", null, "Test12345");
        }
    }

    @And("{string} Request gonderilir ve Response alinir")
    public void requestGonderilirVeResponseAlinir(String request) {
        switch (request) {
            case "POST" -> response = given(spec).body(payLoad).when().post("{first}");
            case "GET" -> response = given(spec).when().get("{first}/{second}");
            case "PATCH" -> response = given(spec).body(payLoad).when().get("{first}/{second}");
            case "Log Out POST" -> response = given(spec).when().post("{first}/{second}");
        }
        response.prettyPrint();
    }

    @Then("Status kodun {int} oldugu dogrulanir")
    public void statusKodunOlduguDogrulanir(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @Then("Add User icin Response Body dogrulanir")
    public void addUserIcinResponseBodyDogrulanir() {
        actualData = response.as(UserRootPojo.class);
        assertNotEquals(null, actualData.getToken());
        assertNotEquals(null, actualData.getUser().get_id());
        assertNotEquals(null, actualData.getUser().get__v());
    }

    @Then("Get User icin Response Body dogrulanir")
    public void getUserIcinResponseBodyDogrulanir() {
        expectedData = response.as(UserPojo.class);
        assertEquals(ConfigReader.getProperty("userEmail"), expectedData.getEmail());
        assertEquals("Alparslan", expectedData.getFirstName());
        assertEquals("Yigid", expectedData.getLastName());
    }


    @Then("Update User icin Response Body dogrulanir")
    public void updateUserIcinResponseBodyDogrulanir() {
        expectedData = response.as(UserPojo.class);
        assertEquals(ConfigReader.getProperty("userEmail"), expectedData.getEmail());
        assertEquals("Alparslan", expectedData.getFirstName());
        assertEquals("Yigid", expectedData.getLastName());
    }
}
