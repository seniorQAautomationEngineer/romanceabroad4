package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BlogTests extends BaseUI {
    String nameOfArticle;
    String titleOfArticle;

    @Test
    public void testArticlesAndTitles() {
        mainPage.clickTabBlog();
        List<WebElement> linksOfArticles = blogPage.collectAllLinksOfArticles();

        for (int i = 0; i < linksOfArticles.size(); i++) {
            WebElement link = linksOfArticles.get(i);
            nameOfArticle = link.getText();
            if (nameOfArticle.contains("How it works")){
            }
           else if (nameOfArticle.contains("Kharkov dating agency")){
            }
           else if (nameOfArticle.contains("Kiev dating agency")){
            }
            else {
                link.click();
                titleOfArticle = blogPage.getAnyTitle();
                Assert.assertEquals(nameOfArticle, titleOfArticle);
                linksOfArticles = blogPage.collectAllLinksOfArticles();
            }
        }
    }
    @Test
    public void testBlogLinks() {
        By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
        By LINK_BLOG_LIST = By.xpath("//div[@class='col-xs-12 col-md-9 content-page']//li//a");

        //Add blog link in variable on main page
        WebElement linkBlog = driver.findElement(LINK_BLOG);

        //Click blog link on main page
        linkBlog.click();

        List<WebElement> links = driver.findElements(LINK_BLOG_LIST);
        for (int i = 0; i < links.size(); i++) {

            String linkText = links.get(i).getText();
            System.out.println(linkText);
            links.get(i).click();
            mainPage.javaWaitSec(3);

            if (linkText.contains("Kharkov dating agency")) {
                Assert.assertTrue(driver.findElement(By.xpath("//h1")).getText().contains("Kharkov Dating & Marriage Agency"));
            }
           else if (linkText.contains("Kiev dating agency")) {
                Assert.assertTrue(driver.findElement(By.xpath("//h1")).getText().contains("Kiev marriage agency"));
            }
                {

                    //Add link "Back" to same variable  with same locator as Blog link on Blog page
                    linkBlog = driver.findElement(LINK_BLOG);

                    //Click link "Back"
                    linkBlog.click();

                    //Refresh list of web elements
                    links = driver.findElements(LINK_BLOG_LIST);
                }
            }
        }
    }
