package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    //This method will click on element

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    //This method will get text from element

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // This method will send text on element

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //*****************             *****************

    public void clearText(By by) {
        Actions actions = new Actions(driver);
        WebElement quantity = driver.findElement(by);
        quantity.clear();
    }
    //***************** Navigate Method****************


//********************* Verify expected Vs Actual Method***************

    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(expectedText, actualText);
    }

    public void verifyMessage(String expectedMessage, String actualMessage) {
        Assert.assertEquals(expectedMessage, actualMessage);
    }


//************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void switchToAcceptAlert() {
        driver.switchTo().alert().accept();

    } // this method will dismiss alert

    public void switchToDismissAlert() {
        driver.switchTo().alert().dismiss();

    }

    // this method will  get text from alert
    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();
        //return driver.findElement(by).getText();
    }

    // this method will sendTextToAlert(String Text)
    public void sendTextToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
        //driver.findElement(by).sendTextToAlert(by,text);

    }  //************************** Select Class Methods *****************************

    //  This method will select option by visible text

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown); //(dropDown = WebElement dropDown = driver.findElement(by);)
        select.selectByVisibleText(text);

    }

    // This method will select the option by value
    public void selectOptionByValue(By by, String value) {
        WebElement optionByValue = driver.findElement(by);
        Select select = new Select(optionByValue);
        select.selectByValue(value);

    }

    //  This method will select the option by index
    public void selectOptionByIndex(By by, int index) {
        WebElement optionByIndex = driver.findElement(by);
        Select select = new Select(optionByIndex);
        select.selectByIndex(index);

    }

    // This method will select the option by contains text
    public void selectOptionByContainsText(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
    }

    //***************************** Action Class *************************************

    // mouseHoverToElement(By by),
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        actions.moveToElement(computer).build().perform();
    }

    //This method will do mouse hover on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement software = driver.findElement(by);
        actions.moveToElement(software).click().build().perform();
    }

}
