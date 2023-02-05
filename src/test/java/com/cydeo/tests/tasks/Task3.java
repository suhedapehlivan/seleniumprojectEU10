package com.cydeo.tests.tasks;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task3 {

    @Test
    public void test() {
        Driver.getDriver().get("http://automationexercise.com");

        Driver.getDriver().findElement(By.xpath("//a[text()=' Products']")).click();

        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("aswift_5")));

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("ad_iframe")));

        Driver.getDriver().findElement(By.xpath("//span[text()='Close']")).click();

        Driver.getDriver().switchTo().defaultContent();


        BrowserUtils.sleep(2);


        WebElement product = Driver.getDriver().findElement(By.id("search_product"));

        product.sendKeys("Men Tshirt");

        Driver.getDriver().findElement(By.id("submit_search")).click();




    }
}
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
 */
