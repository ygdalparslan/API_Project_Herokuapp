package com.herokuapp.stepDefinitions.UI_Steps;

import com.herokuapp.pages.SignUpPage;
import com.herokuapp.utilities.ConfigReader;
import com.herokuapp.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.herokuapp.utilities.ReusableMethods.*;

public class SingnUpStepDef {

    SignUpPage signUpPage=new SignUpPage();

    @Given("Kullanici URL gider")
    public void kullaniciURLGider() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @And("Kullanici {string} butonuna tiklar")
    public void kullaniciButonunaTiklar(String button) {
        switch (button) {
            case "Sign up" -> signUpPage.signUpButton.click();
            case "Submit" -> signUpPage.submitButton.click();
        }
        
    }

    @And("Kullanici {string} girer")
    public void kullaniciGirer(String input) {

        switch (input) {
            case "First Name" -> signUpPage.firstNameBox.sendKeys(firstNameCreator());
            case "Last Name" -> signUpPage.lastNameBox.sendKeys(lastNameCreator());
            case "Email" -> signUpPage.emailBox.sendKeys(emailCreator());
            case "Password" -> signUpPage.passwordBox.sendKeys(passwordCreator());
        }
    }

}
