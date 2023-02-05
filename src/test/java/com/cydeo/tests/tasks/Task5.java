package com.cydeo.tests.tasks;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cydeo.utilities.AddBlock.addBlocker;

public class Task5 {

    @Test
    public void test17() {

        Driver.getDriver().get("http://automationexercise.com");

        Driver.getDriver().findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        Driver.getDriver().findElement(By.xpath("//a[text()=' Cart']")).click();

        Driver.getDriver().findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();

        WebElement current = Driver.getDriver().findElement(By.xpath("//p/b[text()='Cart is empty!']"));

        BrowserUtils.sleep(3);

        Assert.assertEquals(current.getText(), "Cart is empty!");

        Driver.getDriver().close();

        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Add products to cart
        5. Click 'Cart' button
        6. Verify that cart page is displayed
        7. Click 'X' button corresponding to particular product
        8. Verify that product is removed from the cart
         */
    }


    @Test
    public void test18() {

        Driver.getDriver().get("http://automationexercise.com");

        Driver.getDriver().findElement(By.xpath("//a[@href='#Women']")).click();

        Driver.getDriver().findElement(By.xpath(" (//div/ul/li/a[text()='Tops '])[1]")).click();

        addBlocker(Driver.getDriver());


        //Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("aswift_5")));

        //Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("ad_iframe")));

        // Driver.getDriver().findElement(By.id("dismiss-button")).click();

        //  Driver.getDriver().switchTo().defaultContent();


        BrowserUtils.sleep(2);

        WebElement displayText = Driver.getDriver().findElement(By.xpath("//div/h2[text()='Women - Tops Products']"));

        Assert.assertTrue(displayText.isDisplayed());

        Driver.getDriver().findElement(By.xpath("//a[@href='#Men']")).click();

        BrowserUtils.sleep(1);

        Driver.getDriver().findElement(By.xpath("//ul/li/a[text()='Tshirts ']")).click();


        BrowserUtils.sleep(2);

        WebElement currentPage = Driver.getDriver().findElement(By.xpath("//div/h2[text()='Men - Tshirts Products']"));

        Assert.assertTrue(currentPage.isDisplayed());


        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that categories are visible on left side bar
        4. Click on 'Women' category
        5. Click on any category link under 'Women' category, for example: Dress
        6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        7. On left side bar, click on any sub-category link of 'Men' category
        8. Verify that user is navigated to that category page



         */
    }
}