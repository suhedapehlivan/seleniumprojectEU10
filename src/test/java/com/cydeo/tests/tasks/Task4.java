package com.cydeo.tests.tasks;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Task4 {

    @Test
    public void test10() {
        Driver.getDriver().get("http://automationexercise.com");
        WebElement susbText = Driver.getDriver().findElement(By.xpath("//h2[text()='Subscription']"));

        Actions actions = new Actions(Driver.getDriver());

        //  actions.moveToElement(susbText).perform(); // way 1;
        WebElement middle = Driver.getDriver().findElement(By.xpath("//div/p[text()='Green Side Placket Detail T-Shirt']"));

        //  actions.moveToElement(middle).perform();

        // BrowserUtils.sleep(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // js.executeScript("arguments[0].scrollIntoView(true);", susbText); // way 2

        //  BrowserUtils.sleep(2);

        // js.executeScript("arguments[0].scrollIntoView(true);", middle);

        for (int i = 0; i < 11; i++) {
            js.executeScript("window.scrollBy(0,750)"); // way 3
        }

        BrowserUtils.sleep(3);

        Assert.assertTrue(susbText.isDisplayed());

        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Scroll down to footer
        5. Verify text 'SUBSCRIPTION'
        6. Enter email address in input and click arrow button
        7. Verify success message 'You have been successfully subscribed!' is visible
        */
    }

    @Test
    public void test11() {
        Driver.getDriver().get("http://automationexercise.com");
        Driver.getDriver().findElement(By.xpath("//a[text()=' Cart']")).click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());

        WebElement emailInput = Driver.getDriver().findElement(By.xpath("//input[@id='susbscribe_email']"));

        Faker faker = new Faker();

        emailInput.sendKeys(faker.internet().emailAddress());

        Driver.getDriver().findElement(By.id("subscribe")).click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[text()='You have been successfully subscribed!']")).isDisplayed());

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Cart' button
    5. Scroll down to footer
    6. Verify text 'SUBSCRIPTION'
    7. Enter email address in input and click arrow button
    8. Verify success message 'You have been successfully subscribed!' is visible
     */

    }

    @Test
    public void test12() {
        Driver.getDriver().get("http://automationexercise.com");
        Driver.getDriver().findElement(By.xpath("//a[text()=' Products']")).click();

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("aswift_5")));

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("ad_iframe")));

        Driver.getDriver().findElement(By.xpath("//span[text()='Close']")).click();

        Actions actions = new Actions(Driver.getDriver());

        WebElement firstProduct = Driver.getDriver().findElement(By.xpath("//div//p[text()='Blue Top']"));

        WebElement title = Driver.getDriver().findElement(By.xpath("//h2[text()='All Products']"));

        actions.moveToElement(firstProduct).perform();

        BrowserUtils.sleep(4);

        // actions.moveToElement(title).perform();

        WebElement buyButton = Driver.getDriver().findElement(By.xpath("//a[@data-product-id='1']"));

        actions.moveToElement(buyButton).click().perform();

        BrowserUtils.sleep(1);

        Driver.getDriver().findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        BrowserUtils.sleep(2);

        WebElement secondProduct = Driver.getDriver().findElement(By.xpath("//div//p[text()='Men Tshirt']"));


        actions.moveToElement(secondProduct).perform();

        BrowserUtils.sleep(4);

        actions.moveToElement(title).perform();

        Driver.getDriver().findElement(By.xpath("//a[@data-product-id='2']")).click();

        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//a/u")).click();

        BrowserUtils.sleep(2);

        String fproductPrice = Driver.getDriver().findElement(By.xpath("//table[@id='cart_info_table']/tbody/tr[1]//td[3]/p")).getText();
        String fproductQuantity = Driver.getDriver().findElement(By.xpath("//table[@id='cart_info_table']/tbody/tr[1]//td[4]/button")).getText();
        String fproductTotalPrice = Driver.getDriver().findElement(By.xpath("//table[@id='cart_info_table']/tbody/tr[1]//td[5]/p")).getText();

        Assert.assertEquals(fproductPrice, "Rs. 500");
        Assert.assertEquals(fproductQuantity, "1");
        Assert.assertEquals(fproductTotalPrice, "Rs. 500");


        /*
        Test Case 12: Add Products in Cart
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'Products' button
        5. Hover over first product and click 'Add to cart'
        6. Click 'Continue Shopping' button
        7. Hover over second product and click 'Add to cart'
        8. Click 'View Cart' button
        9. Verify both products are added to Cart
        10. Verify their prices, quantity and total price
         */
    }

    @Test
    public void test13() {
        Driver.getDriver().get("http://automationexercise.com");
        Driver.getDriver().findElement(By.xpath("//a[text()=' Products']")).click();

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("aswift_5")));

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("ad_iframe")));

        Driver.getDriver().findElement(By.xpath("//span[text()='Close']")).click();

        Driver.getDriver().findElement(By.xpath("//a[text()='View Product']")).click();

        BrowserUtils.sleep(2);

        WebElement quantity = Driver.getDriver().findElement(By.id("quantity"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(quantity).perform();

        actions.sendKeys(Keys.BACK_SPACE+"4").perform();

        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

        Driver.getDriver().findElement(By.xpath("//a/u[text()='View Cart']")).click();

        BrowserUtils.sleep(3);

        String productQuantity = Driver.getDriver().findElement(By.xpath("//table[@id='cart_info_table']/tbody/tr[1]//td[4]/button")).getText();

        Assert.assertEquals(productQuantity, "4");




        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'View Product' for any product on home page
        5. Verify product detail is opened
        6. Increase quantity to 4
        7. Click 'Add to cart' button
        8. Click 'View Cart' button
        9. Verify that product is displayed in cart page with exact quantity
         */
    }

    @AfterMethod
    public void tearDown() {Driver.getDriver().close();}
}
