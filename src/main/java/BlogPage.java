import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BlogPage extends BaseActions {

    public BlogPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public List<WebElement> collectAllLinksOfArticles(){
        List<WebElement> linksOfArticles = driver.findElements(Locators.LINKS_OF_ACRTICLES);
        return  linksOfArticles;

    }
}
