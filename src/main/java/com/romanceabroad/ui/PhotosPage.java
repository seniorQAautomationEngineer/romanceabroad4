package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhotosPage extends BaseActions {

    public PhotosPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }



    public void clickPhotosTab(){

        driver.findElement(Locators.LINK_MEDIA).click();
    }






}

