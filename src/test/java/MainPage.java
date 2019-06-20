import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPage {
    String mainUrl = "https://romanceabroad.com/";
    WebDriver driver;
    String currentUrlSearch;
    String currentUrlMedia;
    String expectedUrlSearch = "https://romanceabroad.com/users/search";
    String expectedUrlMedia = "https://romanceabroad.com/media/index";
    By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    int indexLinkSignIn = 0;












    String name = "Al";
    By BUTTON_SUBMIT = By.xpath("//a");
    int number = 3;


















    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainUrl);
    }

    @Test
    public void testSearchPage(){
       driver.findElement(LINK_SEARCH).click();
       currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, expectedUrlSearch);
    }

    @Test
    public void testMediaPage(){
       driver.findElement(LINK_MEDIA).click();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        Assert.assertEquals(currentUrlMedia, expectedUrlMedia);
    }

    @Test
    public void testSignIn(){

       driver.findElements(LINK_SIGN_IN).get(indexLinkSignIn).click();



    }


    @Test
    public void testRegistration(){
        driver.findElement(BUTTON_REGISTRATION).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("11@gmail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("11@gmail.com");
     //   driver.findElement(By.xpath("//button[@data-action='next-page'][text()='Next']")).click();

    }


    @AfterMethod
    public void afterActions(){
      //  driver.quit();
    }
}
