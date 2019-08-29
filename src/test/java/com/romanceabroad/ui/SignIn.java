package com.romanceabroad.ui;


import org.testng.Assert;
import org.testng.annotations.Test;



public class SignIn extends BaseUI {

    @Test(dataProvider = "NewRequirementsForPassword", dataProviderClass = DataProviders.class)
    public void password(String password, boolean requirement){
    mainPage.clickSignInLink();
    mainPage.fillInSignInForm(password);
    if(!requirement){
        Assert.assertTrue(driver.findElement(Locators.ALERT_WRONG_PASSWORD).isDisplayed());
    }
    }
}
