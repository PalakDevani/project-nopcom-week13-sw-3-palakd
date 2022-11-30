package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]")); //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h2[1]/a[1]")); //1.2 Mouse Hover on “Cell phones” and click
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");//1.3 Verify the text “Cell phones”
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]")); //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h2[1]/a[1]")); //1.2 Mouse Hover on “Cell phones” and click
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");//1.3 Verify the text “Cell phones”
        clickOnElement(By.linkText("List"));//   2.4 Click on List View Tab
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));   //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        verifyExpectedAndActual(By.xpath("//div[@class='product-name']//h1[1]"), "Nokia Lumia 1020");  //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(2000);
        verifyExpectedAndActual(By.xpath("//span[@id='price-value-20']"), "$349.00");// 2.7 Verify the price “$349.00”
        clearText(By.cssSelector("#product_enteredQuantity_20")); //  2.8 Change quantity to 2
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));//  2.9 Click on “ADD TO CART” tab//pass till here
        verifyExpectedAndActual(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");   //   Verify the Message "The product has been added to your shopping cart" on Top green Bar
        clickOnElement(By.xpath("//span[@class='close']"));//   After that close the bar clicking on the cross button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));  //   2.11 Then MouseHover on "Shopping cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));// and Click on "GO TO CART" button.

        verifyExpectedAndActual(By.xpath("//div[@class='page-title']//h1"), "Shopping cart");  //   2.12 Verify the message "Shopping cart"
        verifyMessage("(2)", getTextFromElement(By.xpath("//span[contains(text(),'(2)')]")));// verify the quantity is 2
        verifyExpectedAndActual(By.xpath("//span[@class='product-subtotal']"), "$698.00");   //   2.14 Verify the Total $698.00

        clickOnElement(By.xpath("//input[@id='termsofservice']"));//   2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//button[@id='checkout']"));//   2.16 Click on “CHECKOUT”

        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");//   2.17 Verify the Text “Welcome, Please Sign In!”

        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));  //   2.18 Click on “REGISTER” tab
        verifyExpectedAndActual(By.xpath("//div[@class='page-title']/h1"), "Register");  //  2.19 Verify the text “Register”

        sendTextToElement(By.xpath("//input[@id='FirstName']"), "prmee");   //  2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Tes");   //  2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='Email']"), "tear011@gmail.com");   //  2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='Password']"), "123425");   //  2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "123425");   //  2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//button[@id='register-button']")); //  2.21 Click on “REGISTER” Button
        verifyExpectedAndActual(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");  //  2.22 Verify the message “Your registration completed”
        clickOnElement(By.xpath("//div[@class='buttons']/a")); //  2.23 Click on “CONTINUE” tab
        verifyExpectedAndActual(By.xpath("//div[@class='page-title']/h1"), "Shopping cart");  //  2.24 Verify the text “Shopping card”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));  //  2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//button[@id='checkout']"));  //  2.26 Click on “CHECKOUT”

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Pala");// 2.27 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Dev");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "tetin@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "Japan");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Tokeyo");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "25,Bapunager");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "382350");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9876543210");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']")); //Click on “CONTINUE”

//  2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

//  2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

//  2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));

//  2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

//  2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Pala");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "1");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "132");

//  2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));

//  2.35 Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//li[@class='payment-method']/span[2]"), "Credit Card");

//  2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyExpectedAndActual(By.xpath("//li[@class='shipping-method']/span[2]"), "2nd Day Air");

//  2.37 Verify Total is “$698.00”
        verifyExpectedAndActual(By.xpath("//span[@class='value-summary']/strong"), "$698.00");

//  2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));

//  2.39 Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("//h1[text()='Thank you']"), "Thank you");

//  2.40 Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

//  2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='setLocation(\"/\")']"));

//  2.42 Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

//  2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));


//  2.44 Verify the URL is “https://demo.nopcommerce.com/”
        verifyExpectedAndActual(By.linkText("nopCommerce.com"), "nopCommerce.com");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
