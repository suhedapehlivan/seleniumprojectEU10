package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
      //  driver.findElement(By.className("login-inp")).sendKeys("incorrect");  -> true, but not reusable
        WebElement inputUsername = driver.findElement(By.className("login-inp"));
        inputUsername.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        //to auto generate local variable
        // after you write this: driver.findElement(By.name("USER_PASSWORD"))
        // and click option enter and select introduce local variable
        //mac: option+enter windows: alt+enter
        WebElement userPassword = driver.findElement(By.name("USER_PASSWORD"));
        userPassword.sendKeys("incorrect");


        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));
        //PS: Inspect and decide which locator you should be using to locate web elements.

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();
        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message verification PASSED!");
        }else {
            System.out.println("Error message verification FAILED!");
        }
    }
}
