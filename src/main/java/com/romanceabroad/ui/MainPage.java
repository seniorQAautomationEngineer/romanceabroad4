package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    @FindBy(xpath = "//button[@id='show-registration-block']")
    WebElement registrationButton;

    public MainPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickJoinButton(){
        Reports.log("Wait Join button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_REGISTRATION));

        Reports.log("Click Join button");
        registrationButton.click();
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
       // Reports.log("Wait email text field");
       // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        javaWaitSec(3);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Locators.TEXT_FIELD_EMAIL_REGISTRATION)));

        Reports.log("Type email in text field: " + email);
        driver.findElement(Locators.TEXT_FIELD_EMAIL_REGISTRATION).sendKeys(email);

        Reports.log("Wait password text field");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD_REGISTRATION)));

        Reports.log("Type password in text field: " + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD_REGISTRATION).sendKeys(password);


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


    public void clickMobileMenu(String valueOfBox){
        if(valueOfBox.contains("mobile")){
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }

    public void clickMobileMenu(){
        try {
            driver.findElement(Locators.MOBILE_MENU).click();
        }catch (Exception e){

        }

    }
    public void clickMobileMenu2(){
        if(driver.findElement(Locators.MOBILE_MENU).isDisplayed()){
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }
    public void clickMobileMenu3(){
        if(driver.findElements(Locators.MOBILE_MENU).size() > 0){
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }
public void clickSignInLink(){
       javaWaitSec(3);
    driver.findElement(Locators.LINK_SIGN_IN).click();
}
public void fillInSignInForm(String password){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(Locators.TEXT_FIELD_EMAIL_SIGN_IN).sendKeys(Data.email1);
    driver.findElement(Locators.TEXT_FIELD_PASSWORD_SIGN_IN).sendKeys(password);
    driver.findElement(Locators.BUTTON_SUBMIT_SIGN_IN).click();
}
}
