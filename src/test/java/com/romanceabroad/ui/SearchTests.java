package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseUI {
    String currentUrlSearch;

    public static final boolean testCase11 = true;
    public static final boolean testCase12 = false;
    public static final boolean testCase13 = false;
    public static final boolean testCase14 = false;


    @Test(priority = 2, enabled = testCase12, groups = {"ie", "user", "admin"})
    public void testSearchPageTestCase12() {
        Assert.assertTrue(driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
        searchPage.clickPrettyWomen();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //  Assert.assertEquals(currentUrlSearch, com.romanceabroad.ui.Data.expectedUrlSearch);
        softAssert.assertEquals(currentUrlSearch, Data.expectedUrlSearch, "Url is wrong");
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
        searchPage.getDropDownListByValue(dropDownListSortBy, "date_created");
        softAssert.assertAll();
    }


    @Test(priority = 1, enabled = testCase11, groups = {"user", "admin"})
    public void selectRandomDropDownListTestsOnSearchPageCase11() {

        mainPage.clickMobileMenu(valueOfBox);
        searchPage.clickPrettyWomen();
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList(Locators.DROP_DOWN_MAX_AGE);
        System.out.println(sizeOfDropDownListSortBy);
        searchPage.clickSearchParameters(valueOfBox);
        for (int i = 0; i < 2; i++) {
            searchPage.selectItemDropDownRandomOption(Locators.DROP_DOWN_MAX_AGE, "Sort by");
            mainPage.javaWaitSec(3);
        }

    }


    @Test(dataProvider = "Search", dataProviderClass = DataProviders.class, priority = 3, enabled = testCase13, groups = {"user", "admin"})
    public void searchDifferentResults13(String minAge, String maxAge, String sortBy) {
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);


        searchPage.clickPrettyWomen();
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_MIN_AGE), minAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_MAX_AGE), maxAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);
        searchPage.clickSearchButton();

        List<WebElement> infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);

        for (int i = 0; i < infoAboutUser.size(); i++) {
            if (i % 2 == 0) {
                WebElement text = infoAboutUser.get(i);
                String info = text.getText();
                String[] splitedPhrase = info.split(", ");
                String age = splitedPhrase[1];
                int ageNum = Integer.parseInt(age);

                if (min <= ageNum || ageNum <= max) {
                    System.out.println("This age: " + ageNum + " is correct");
                } else {
                    Assert.fail("Wrong age: " + ageNum);
                }
            }
            mainPage.javaWaitSec(3);
            infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);

        }
    }


    @Test(dataProvider = "Search", dataProviderClass = DataProviders.class, priority = 3, enabled = testCase14, groups = {"user", "admin"})
    public void searchDifferentResults14(String minAge, String maxAge, String sortBy) {
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

    @Test
    public void searchByDropDownLists() {
        searchPage.clickPrettyWomen();
        int sizeOFSortList = searchPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_SORT_BY);
        System.out.println(sizeOFSortList);
        for (int i = 0; i <sizeOFSortList ; i++) {
            System.out.println(i);
            searchPage.getDropDownListByIndex(Locators.DROP_DOWN_LIST_SORT_BY, i);
        }


    }
    @Test
    public void searchByDropDownListsReverse() {
        searchPage.clickPrettyWomen();
        int sizeOFSortList = searchPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_SORT_BY);

        for (int i = 3; i > -1; i--) {
            System.out.println(i);
            searchPage.getDropDownListByIndex(Locators.DROP_DOWN_LIST_SORT_BY, i);

        }


    }

}































