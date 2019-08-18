package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Draft1 extends BaseUI{

@Test
    public void test2Lists(){
   driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']")).click();
    List<WebElement> articlesLinks = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']/li"));

    mainPage.ajaxClick(By.xpath("//ul[@class='footer-menu-list-block list-group']//a[@href='https://romanceabroad.com/tickets/']"));
    mainPage.ajaxClick(By.xpath("//input[@name='btn_save']"));
    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error alert-danger alert-warning_pop_']")).isDisplayed());
   String errors = driver.findElement(By.xpath("//div[@class='error alert-danger alert-warning_pop_']")).getText();
    System.out.println(errors);

    /* for (int i = 0; i <articlesLinks.size() ; i++) {
        WebElement links = articlesLinks.get(i);
        String nameOFArtcile = links.getText();
        links.click();
        String titelOfArticle = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(articlesLinks);
        if(!nameOFArtcile.contains("How it works")) {
        Assert.assertEquals(nameOFArtcile, titelOfArticle);
        }
            articlesLinks = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']/li"));

    }*/

}

    @Test(dataProvider = "Search", dataProviderClass = DataProviders.class, priority = 3,  groups = {"user", "admin"})
    public void searchDifferentResults13(String minAge, String maxAge, String sortBy) {
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);
        System.out.println(min);
        System.out.println(max);

        searchPage.clickPrettyWomen();
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_MIN_AGE), minAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_MAX_AGE), maxAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);
        searchPage.clickSearchButton();

        List<WebElement> infoAboutUser = driver.findElements(By.xpath("//div[@class='text-overflow']"));
        List<WebElement> regions = driver.findElements(By.xpath("//div[@class='text-overflow']//a"));
        //infoAboutUser.removeAll(regions);

        for (int i = 0; i < infoAboutUser.size(); i++) {
            if (i % 2 == 0) {
                WebElement text = infoAboutUser.get(i);
                String info = text.getText();
                String[] splitedPhrase = info.split(", ");
                String age = splitedPhrase[1];
                System.out.println(age);
                int ageNum = Integer.parseInt(age);
                if (min <= ageNum && ageNum <= max) {

                    System.out.println("Age " + ageNum + "  is correct");
                } else {
                    Assert.fail("Age is outside of range: " + ageNum);
                }
            }

            mainPage.javaWaitSec(3);
            infoAboutUser = driver.findElements(By.xpath("//div[@class='text-overflow']"));
        }

    }




}
