package com.cydeo.tests.tasks;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;

public class robot_addBlocker {
    @Test
    public void test1() throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationexercise.com");
        Thread.sleep(4000);
        Robot rb =new Robot();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        Dimension i = driver.manage().window().getSize();
        System.out.println(i);
        System.out.println("Dimension x and y :"+i.getWidth()+" "+i.getHeight());
        int x = (i.getWidth()/4)+100;
        int y = (i.getHeight()/10)+200;
        System.out.println(x+":"+y);

        WebElement viewProduct=driver.findElement(By.xpath("//a[.='View Product']"));
        js.executeScript("arguments[0].scrollIntoView(true)", viewProduct);
        Thread.sleep(3000);
        viewProduct.click();

        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pop=driver.findElement(By.xpath("//*[@data-vignette-loaded='true']"));

        if (pop.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(pop));
            rb.mouseMove(x, y);
            rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            rb.delay(1000);
            rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            rb.delay(1000);
            //pop.click();
            Thread.sleep(3000);
        }

        WebElement add=driver.findElement(By.xpath("//button[@type='button']"));
        wait.until(ExpectedConditions.elementToBeClickable(add));
        add.click();
        Thread.sleep(3000);


        WebElement vc=driver.findElement(By.xpath("//u[contains(.,'View Cart')]"));
        wait.until(ExpectedConditions.elementToBeClickable(vc));
        vc.click();
        driver.close();
    }
}