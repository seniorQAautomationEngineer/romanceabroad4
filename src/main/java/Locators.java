import org.openqa.selenium.By;

public class Locators {

    public static  final By H1_TITLE = By.xpath("//h1");

    //Media page
    public static  final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");


    //Registration
    public static  final By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    public static  final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static  final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static  final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static  final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static  final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static  final By LIST_DAYS = By.cssSelector("#daySelect");
    public static  final By LIST_MONTHS = By.cssSelector("#monthSelect");
    public static  final By LIST_YEARS = By.cssSelector("#yearSelect");
    public static  final By LIST_VALUE_DAY = By.xpath("//li[@data-handler='selectDay']");
    public static  final By LIST_VALUE_MONTH = By.xpath("//li[@data-handler='selectMonth']");
    public static  final By LIST_VALUE_YEAR =By.xpath("//li[@data-handler='selectYear']");
    public static  final By CHECKBOX_CONFIRMATION =By.cssSelector("input#confirmation");
    public static  final By AUTOFILLING_FORM_LOCATION =By.xpath("//input[@name='region_name']");
    public static  final By LIST_VALUE_LOCATION =By.xpath("//div[@class='dropdown dropdown_location']//ul//li");


    //Search page
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_MAX_AGE = By.cssSelector("select#age_max");


    //Blog page
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By LINKS_OF_ACRTICLES = By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");
}
