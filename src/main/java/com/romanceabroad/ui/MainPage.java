package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    public MainPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickJoinButton(){
        Reports.log("Wait Join button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_REGISTRATION));

        Reports.log("Click Join button");
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    public void javaWait(int ms){
        System.out.println("Child!!!!");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void completeFirstPartOfRegistration(String email, String password){
        Reports.log("Wait email text field");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Locators.TEXT_FIELD_EMAIL)));

        Reports.log("Type email in text field: " + email);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);

        Reports.log("Wait password text field");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));

        Reports.log("Type password in text field: " + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);


    }

    public void clickNextButton(){
        Reports.log("Wait Next button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));

        Reports.log("Click Next button");
       driver.findElement(Locators.BUTTON_NEXT).click();
    }

    public void completeSecondPartOfRegistration(String nickname, String phone, String month, String day,
                                                 String year, String city, String location){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Reports.log("Type nickname: " + nickname);
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        Reports.log("Click list of days");
        driver.findElement(Locators.LIST_DAYS).click();

        Reports.log("Select specific day: " + day);
        clickValueOfLists(Locators.LIST_VALUE_DAY, day);

        Reports.log("Click list of months");
        driver.findElement(Locators.LIST_MONTHS).click();

        Reports.log("Select specific month: " + month);
        clickValueOfLists(Locators.LIST_VALUE_MONTH, month);

        Reports.log("Click list of years");
        driver.findElement(Locators.LIST_YEARS).click();

        Reports.log("Select specific year: " + year);
        clickValueOfLists(Locators.LIST_VALUE_YEAR, year);

        Reports.log("Type phone number: " + phone);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);

        Reports.log("Click confirmation checkbox");
        driver.findElement(Locators.CHECKBOX_CONFIRMATION).click();

        Reports.log("Clean location autofilling form");
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).clear();

        Reports.log("Type ane of city: " + city);
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).sendKeys(city);

        clickValueOfLists(Locators.LIST_VALUE_LOCATION, location);

    }

   public void clickTabBlog(){
        driver.findElement(Locators.LINK_BLOG).click();
}




}
