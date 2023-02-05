package com.cydeo.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddBlock {
    public static void addBlocker(WebDriver driver){

        if(isIframePopupPresent(driver)){

            driver.switchTo().frame(Driver.getDriver().findElement(By.id("aswift_5")));

            driver.switchTo().frame(Driver.getDriver().findElement(By.id("ad_iframe")));

            driver.findElement(By.id("dismiss-button")).click();

            driver.switchTo().defaultContent();

        }
    }

    public static boolean isIframePopupPresent(WebDriver driver) {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        return !iframes.isEmpty();
    }
}