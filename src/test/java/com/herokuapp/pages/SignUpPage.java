package com.herokuapp.pages;

import com.herokuapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {



    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id= "signup") public WebElement signUpButton;
    @FindBy(id= "firstName") public WebElement firstNameBox;
    @FindBy(id= "lastName") public WebElement lastNameBox;
    @FindBy(id= "email") public WebElement emailBox;
    @FindBy(id= "password") public WebElement passwordBox;
    @FindBy(id= "submit") public WebElement submitButton;




}
