package com.romanceabroad.ui;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseUI {
    WebDriver driver;
    WebDriverWait wait;

    MainPage mainPage;
    SearchPage searchPage;
    BlogPage blogPage;
    PhotosPage photosPage;
    SoftAssert softAssert = new SoftAssert();

    protected TestBox testBox;
    protected TestBrowser testBrowser;

    protected String valueOfBox;


    protected enum TestBox {
        WEB, MOBILE, SAUCE
    }

    protected enum TestBrowser {
        CHROME, FIREFOX, IE, REMOTE_CHROME, REMOTE_FIREFOX
    }


    @BeforeMethod(groups = {"user", "admin", "ie"}, alwaysRun = true)
    @Parameters({"browser", "testBox", "platform", "version", "deviceName", "testEnv"})

    public void setup(@Optional("chrome") String browser, @Optional("web") String box,
                      @Optional("null") String platform,
                      @Optional("null") String version, @Optional("null") String device,
                      @Optional("qa") String env,
                      Method method, ITestContext context) throws MalformedURLException {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if (box.equalsIgnoreCase("web")) {
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        } else if (box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        }

        if (browser.equalsIgnoreCase("chrome")) {
            testBrowser = TestBrowser.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            testBrowser = TestBrowser.FIREFOX;
        } else if (browser.equalsIgnoreCase("ie")) {
            testBrowser = TestBrowser.IE;
        } else if (browser.equalsIgnoreCase("remoteChrome")) {
            testBrowser = TestBrowser.REMOTE_CHROME;
        } else if (browser.equalsIgnoreCase("remoteFirefox")) {
            testBrowser = TestBrowser.REMOTE_FIREFOX;
        }


        switch (testBox) {
            case WEB:

                switch (testBrowser) {

                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                        driver = new FirefoxDriver();
                        break;

                    case CHROME:
                        System.out.println("Chrome");
                        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;

                    case IE:
                        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                        driver = new InternetExplorerDriver();
                        driver.manage().deleteAllCookies();
                        break;

                    case REMOTE_CHROME:
                        System.out.println("Remote Chrome");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                        break;

                    case REMOTE_FIREFOX:
                        System.out.println("Remote Firefox");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless");
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                        break;

                    default:
                        System.out.println("Default");
                        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;

                }
                //driver.manage().window().maximize();
                break;

            case MOBILE:

                switch (testBrowser) {
                    case CHROME:
                        System.out.println("Mobile Chrome");
                        Map<String, String> mobileEmulation = new HashMap<String, String>();
                        mobileEmulation.put("deviceName", "Galaxy S5");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                        driver = new ChromeDriver(chromeOptions);
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                }
                break;

            case SAUCE:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("username", "Alex1985");
                capabilities.setCapability("accessKey", "92b76e2d-943d-4bc1-9e57-21f50a85e3b2");
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("platform", platform);
                capabilities.setCapability("version", version);
                capabilities.setCapability("name", method.getName());
                driver = new RemoteWebDriver(
                        new URL("http://" + System.getenv("SAUCE_USERNAME") + ":" + System.getenv("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);
                break;

        }



        wait = new WebDriverWait(driver, 20);


        mainPage = new MainPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);

        driver.manage().window().maximize();






        PageFactory.initElements(driver, mainPage);
        PageFactory.initElements(driver, searchPage);
        PageFactory.initElements(driver, blogPage);

        if (env.contains("qa")) {
            driver.get(Data.mainUrl);
        } else if (env.contains("uat")) {
            driver.get("https://www.google.com/");
        } else if (env.contains("prod")) {
            driver.get("https://www.yahoo.com/");
        }

        valueOfBox = box;
    }

    @AfterMethod
    public void afterActions(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

    // driver.quit();
    }


}
