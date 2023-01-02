package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.Sleep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5 {
    public static void main(String[] args) throws InterruptedException {
        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        // 3- Enter incorrect username into login box:
        WebElement incorrectUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));

        //4- Click to `Reset password` button
       incorrectUsername.sendKeys("dkfjndjjkdnf");


       WebElement resetPassw = driver.findElement(By.xpath("//button[@value='Reset password']"));
       resetPassw.click();

        Sleep.sleep(2);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       WebElement error = driver.findElement(By.xpath("//div[@class='errortext']"));

       String expexted = "Login or E-mail not found";
       String actual = error.getText();
        System.out.println(actual.equals(expexted));
        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found


        //PS: Inspect and decide which locator you should be using to locate web elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
