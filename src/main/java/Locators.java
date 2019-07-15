import org.openqa.selenium.By;

public class Locators {

    //Media page
    public static  final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");


    //Registration
    public static  final By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    public static  final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static  final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static  final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static  final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static  final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");

    //Search page
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_MAX_AGE = By.cssSelector("select#age_max");
}
