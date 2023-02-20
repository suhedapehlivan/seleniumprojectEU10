package com.cydeo.tests.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class addBlocker {
    @Test
    public static void addBlocker() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        /*ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
       */
        driver.get("http://automationexercise.com");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement viewProduct=driver.findElement(By.xpath("//a[.='View Product']"));
        js.executeScript("arguments[0].scrollIntoView(true)", viewProduct);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.elementToBeClickable(viewProduct));
        viewProduct.click();

        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Thread.sleep(3000);

        WebElement pop=driver.findElement(By.xpath("//*[@data-vignette-loaded='true']"));

        if (pop.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(pop));
            pop.click();
            //executor.executeScript("arguments[0].click();", pop);
            Thread.sleep(3000);
            if(!driver.getCurrentUrl().contains("automationexercise")){
                driver.navigate().back();
                Thread.sleep(3000);
            }

        }
/*
 try {
            //wait.until(ExpectedConditions.elementToBeClickable(pop));
            pop.click();
        }catch (ElementClickInterceptedException e){
            System.out.println("interception");
        }


*/
        // WebElement pop=driver.findElement(By.xpath("//span[.='Close']"));
        //pop.click();
        //Alert alert=driver.switchTo().alert();
        //alert.dismiss();
        //driver.switchTo().frame(driver.findElement(By.id("aswift_5")));
        //driver.findElement(By.xpath("//*[.='Close']")).click();

        WebElement add=driver.findElement(By.xpath("//button[@type='button']"));
        wait.until(ExpectedConditions.elementToBeClickable(add));
        add.click();
        if (pop.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(pop));
            pop.click();
            //executor.executeScript("arguments[0].click();", pop);
            Thread.sleep(3000);
            if(!driver.getCurrentUrl().contains("automationexercise")){
                driver.navigate().back();
                Thread.sleep(3000);
            }
        }

/*
        try {
            //wait.until(ExpectedConditions.elementToBeClickable(pop));
            pop.click();
        }catch (ElementClickInterceptedException e){
            System.out.println("interception");
        }
       */
        //executor.executeScript("arguments[0].click();", pop);

        //  wait.until(ExpectedConditions.elementToBeClickable(pop)); pop.click();

        WebElement vc=driver.findElement(By.xpath("//u[contains(.,'View Cart')]"));
        wait.until(ExpectedConditions.elementToBeClickable(vc));
        vc.click();
        driver.close();



    }


}
