package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import utilities.Utility;

import java.awt.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyProductArrangeInAlphabaticalOrder() {
        clickOnElement(By.linkText("Computers")); // Click on Computer Menu.
        mouseHoverToElementAndClick(By.linkText("Desktops")); // click on desktops
        mouseHoverToElementAndClick(By.xpath("//div[@class='product-sorting']"));// clicks on 'sortBy'
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");//Select Sort By position "Name: Z to A"
        String expectedText = "Name: Z to A"; // this is from requirement
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals(expectedText, actualText);     //Verify the expected Vs Actual
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.linkText("Computers")); // Click on Computer Menu.
        clickOnElement(By.linkText("Desktops")); // Click on Desktop
        mouseHoverToElementAndClick(By.xpath("//div[@class='product-sorting']")); // clicks on 'sort by'
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");// Select Sort By position "Name: A to Z"
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));//Click on "Add To Cart"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
        //verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");  //Verify the Text "Build your own computer"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");// Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]"); //  Select "8GB [+$60.00]" using Select class.
        Thread.sleep(3000);
        clickOnElement(By.cssSelector("#product_attribute_3_7"));// Select HDD radio "400 GB [+$100.00]"

        clickOnElement(By.cssSelector("#product_attribute_4_9"));// Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(3000);
        clickOnElement(By.id("product_attribute_5_12"));  // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        Thread.sleep(1000);
        //clickOnElement(By.id("//input[@id='product_attribute_5_10']"));
        Thread.sleep(3000);
        verifyExpectedAndActual(By.id("price-value-1"), "$1,475.00");// Verify the price "$1,475.00"
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']")); // 2.12 Click on "ADD TO CARD" Button.
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");//  2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        clickOnElement(By.xpath("//span[@class='close']"));//  After that close the bar clicking on the cross button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));// 2.14 Then MouseHover on "Shopping cart"
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));// and Click on "GO TO CART" button.
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");//  2.15 Verify the message "Shopping cart"
        clearText(By.xpath("//input[@value='1']"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@value='1']"), "2");// 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$2,950.00");// 2.17 Verify the Total"$2,950.00"
        clickOnElement(By.xpath("//input[@id='termsofservice']")); // 2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("checkout")); // 2.19 Click on “CHECKOUT”  xpath: //button[@id='checkout']
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");  // 2.20 Verify the Text “Welcome, Please Sign In!”
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));// 2.21Click on “CHECKOUT AS GUEST”Tab
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Pal");// 2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "De");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "testin@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        //sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Ahmedabad");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "25,Bapunager");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "382350");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9876543210");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));  // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']")); // 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));// 2.25 Click on “CONTINUE”
        clickOnElement(By.cssSelector("#paymentmethod_1"));// 2.26 Select Radio Button “Credit Card”
        Thread.sleep(5000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");// 2.27 Select “Master card” From Select credit card dropdown
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Pal"); // 2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "1");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));// 2.29 Click on “CONTINUE”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");// 2.30 Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "Next Day Air");// 2.32 Verify “Shipping Method” is “Next Day Air”
        verifyExpectedAndActual(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "");// 2.33 Verify Total is “$2,950.00”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));// 2.34 Click on “CONFIRM”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");// 2.35 Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");// 2.36 Verify the message “Your order has been successfully processed!”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));// 2.37 Click on “CONTINUE”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");// 2.37 Verify the text “Welcome to our store”


    }@After
    public void tearDown(){
        closeBrowser();
    }
}
