package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPage extends BaseActions {

    public SearchPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }



    public void clickPrettyWomen(){
        driver.findElement(Locators.LINK_SEARCH).click();
    }

    public  void clickSearchButton(){
        driver.findElement(Locators.BUTTON_SEARCH).click();
    }





  public void clickSearchParameters(String valueOfBox){
      if(valueOfBox.contains("mobile")){
          driver.findElement(Locators.MOBILE_LINK_SEARCH_PARAMETERS).click();
      }

  }





}

