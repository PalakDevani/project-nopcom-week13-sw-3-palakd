package homepage;

import browserfactory.BaseTest;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    /*/method with name "selectMenu" it has one parameter name "menu" of type string
This method should click on the menu whatever name is passed as parameter.*/

    public void selectMenu(String menu, By by) {
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }

        }
    }

    @Test
    //selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyUserCanNavigateToComputerMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
        selectMenu("Computers", By.linkText("Computers"));
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"), "Computers");

//        String expectedTab = "Computers";
//        String actualTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
//        Assert.assertEquals(expectedTab,actualTab);
    }

    @Test
    //selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyUserCanNavigateToElectronicsMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
        selectMenu("Electronics", By.linkText("Electronics"));
        String expectedTab = "Electronics";
        String actualTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        Assert.assertEquals(expectedTab, actualTab);
    }

    @Test
    //selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyUserCanNavigateToApparelMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
        selectMenu("Apparel", By.linkText("Apparel"));
        String expectedTab = "Apparel";
        String actualTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        Assert.assertEquals(expectedTab, actualTab);
    }

    @Test
    //selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyUserCanNavigateToDigitalDownloadsMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
        selectMenu("Digital downloads", By.linkText("Digital downloads"));
        String expectedTab = "Digital downloads";
        String actualTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        Assert.assertEquals(expectedTab, actualTab);
    }

    @Test

    //selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyUserCanNavigateToBooksMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
        selectMenu("Books", By.linkText("Books"));
        String expectedTab = "Books";
        String actualTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
        Assert.assertEquals(expectedTab, actualTab);
    }

    @Test
    //selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyUserCanNavigateToJewelryMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
        selectMenu("Jewelry", By.linkText("Jewelry"));
        String expectedTab = "Jewelry";
        String actualTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        Assert.assertEquals(expectedTab, actualTab);
    }

    @Test
    //selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyUserCanNavigateToGiftCardsMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
        selectMenu("Gift Cards", By.linkText("Gift Cards"));
        String expectedTab = "Gift Cards";
        String actualTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        Assert.assertEquals(expectedTab, actualTab);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
