package com.romanceabroad.ui;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.Assert;


import org.testng.annotations.Test;


@Listeners(VideoListener.class)


public class RegistrationTests extends  BaseUI{



    @Video(name = "Registration test")
    @Test(dataProvider = "Registration2", dataProviderClass = DataProviders.class)
    public void testRegistration2(String email, String nickname, boolean requirement, ITestContext context) {


        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);

        if(!requirement) {
            Reports.log("Error message is not displayed");
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
        }else {
            mainPage.clickNextButton();
            mainPage.completeSecondPartOfRegistration(nickname, Data.phone,
                    Data.month, Data.day, Data.year, Data.city, Data.location);
        }


    }






}
