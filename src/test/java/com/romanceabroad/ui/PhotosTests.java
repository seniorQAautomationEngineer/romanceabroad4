package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PhotosTests extends BaseUI {
    String actualTitle;

    @Test
    public void testUserTabs() {
        photosPage.clickPhotosTab();
        List<WebElement> userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        actualTitle = photosPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);

        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = photosPage.getAnyTitle();
            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideoGallery);
               // mainPage.ajaxClick(By.xpath("//div[@class='g-flatty-block']"));
                String textMedia = driver.findElement
                        (By.xpath("//div[@class='g-flatty-block']")).getText();
                if (textMedia.contains(Data.textMedia)){
                    System.out.println("Text media is correct!");
                }
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGalleryAlbums);
                mainPage.javaWaitSec(2);
                Assert.assertTrue(driver.findElement
                        (By.xpath("//span[@data-click='album']")).isDisplayed());
            }

            userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        }
    }
}

