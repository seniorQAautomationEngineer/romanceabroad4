package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
