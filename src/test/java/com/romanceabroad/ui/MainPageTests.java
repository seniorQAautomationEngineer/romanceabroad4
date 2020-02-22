package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends BaseUI {


    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']"));
        driver.switchTo().frame(ele);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        System.out.println("!!!");
    }


    @Test
    public void testLinksOnMainPage() {
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");
        driver.findElement(Locators.LINK_SEARCH);
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");

    }



  @Test
    public  void smokeTestMainPage(){
        List<WebElement> mainTabs = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li/a"));
        for (int i = 0; i <mainTabs.size() ; i++) {
            mainTabs.get(i).click();
            driver.get(Data.mainUrl);
            mainTabs = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li/a"));
        }
}


@Test
    public void print(){
        mainPage.javaWait(5000);
}

    @Test
    public void testSearchField(){
        driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']")).click();
        driver.findElement(By.cssSelector("input#search_product")).sendKeys("#");
        driver.findElement(By.cssSelector("button#search_friend")).click();
        String info =  driver.findElement(By.xpath("//div[@class='store-main-block']//h2")).getText();
        System.out.println(info);
        Assert.assertEquals("No items", info);

    }

    @Test
    public void signInButton() {
        driver.findElement(By.cssSelector("a[href='https://romanceabroad.com/users/login_form']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@gmail.com");
    }
}
