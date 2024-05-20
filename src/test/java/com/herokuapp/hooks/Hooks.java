package com.herokuapp.hooks;

import com.herokuapp.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.herokuapp.baseUrl.BaseUrl.setUp;

public class Hooks {

    @Before("@api")
    public void beforeApi(){
        setUp();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if( scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES),"image/png","scenario"+scenario.getName());
            Driver.closeDriver();
        }
        Driver.closeDriver();
    }

}