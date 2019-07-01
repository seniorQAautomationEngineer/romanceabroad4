import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaTests extends BaseUI {
    String currentUrlMedia;


    @Test
    public void testMediaPage() {
        driver.findElement(Locators.LINK_MEDIA).click();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        Assert.assertEquals(currentUrlMedia, Data.expectedUrlMedia);
    }

}
