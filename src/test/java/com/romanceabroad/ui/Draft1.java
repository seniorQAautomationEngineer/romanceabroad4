package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Draft1 extends BaseUI {

    @Test
    public void test2Lists() {
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

    @Test(dataProvider = "Search", dataProviderClass = DataProviders.class, priority = 3, groups = {"user", "admin"})
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


    public static void main(String[] args) {
        test(Arrays.asList(7, 2, 6, 3));
    }

    public static int test(List<Integer> indexes) {
        if (indexes.isEmpty()) {
            return 0;
        }
        return Collections.max(indexes);

    }

    public static int test2(List<Integer> indexes) {
        int number = Integer.MIN_VALUE;

        if (indexes.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) > number)
                number = indexes.get(i);
        }
        return number;

    }

    @Test
    public void arrayListWithString1() {
        String phrase = "This list contains Gifts tab";
        List<String> listOfTabs = new ArrayList<>(Arrays.asList("Home", "How We Work", phrase, "Pretty Women", "Blog", "Sign In"));
        System.out.println(listOfTabs);

        for (int i = 0; i < listOfTabs.size(); i++) {


            System.out.println("Iteration" + i);
            if (listOfTabs.get(i).contains("Pretty Women")) {
                System.out.println(listOfTabs.get(i));
                continue;
            }
            if (listOfTabs.get(i).contains("ZZZ")) {
                System.out.println(listOfTabs.get(i));
                continue;
            }
            if (listOfTabs.get(i).equals("Blog")) {
                System.out.println(listOfTabs.get(i));
                continue;
            } else {
                System.out.println("Bad Loop");
            }
        }
    }

    @Test
    public void testHowWeWorkPage() {
        By LIST_OF_LINKS = By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");
        String expected_title = "Advertising";
        String expected_URL = "https://romanceabroad.com/content/view/advertising";
        driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']")).click();
        List<WebElement> howWeWorkLinks = driver.findElements(LIST_OF_LINKS);
        System.out.println(howWeWorkLinks.size());

        for (int i = 0; i < howWeWorkLinks.size(); i++) {
            String linksNames = howWeWorkLinks.get(i).getText();
            System.out.println(linksNames);

            howWeWorkLinks.get(i).click();
            if(linksNames.contains(expected_title)) {
                String actualTitle = driver.findElement(By.xpath("//div[contains(text(),'Advertising')]")).getText();
       // No sense for this assert, you checked title already in if         Assert.assertEquals(expected_title, actualTitle);
                String actual_URL = driver.getCurrentUrl();
                Assert.assertEquals(expected_URL, actual_URL);
                driver.findElement(By.xpath("//div[contains(@class,'user-carousel-line')] ")).isDisplayed();
                if (actual_URL.contains("#")) {
                    Assert.fail("Bad URL");
                } else {
                    System.out.println("The bug is fixed");
                }
            }

            howWeWorkLinks = driver.findElements(LIST_OF_LINKS);
        }
    }

    @Test
    public void testDefaultDropdown () {
        driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/users/search']"));
        int sizeOfDropDownListSortBy= searchPage.getSizeDropDownList(DEFAULT_DROPDOWN);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            mainPage.selectItemDropDownRandomOption(DEFAULT_DROPDOWN, "Sort by");
            mainPage.javaWaitSec(3);
        }
    }
    By DEFAULT_DROPDOWN = By.xpath("//div[@class='form-inline']//select[@id='sorter-select-9326']");
}
