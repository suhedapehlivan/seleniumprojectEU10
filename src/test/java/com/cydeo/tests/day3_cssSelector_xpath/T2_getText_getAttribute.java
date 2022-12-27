package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if (expectedRememberMeLabel.equals(actualRememberMeLabel)){
            System.out.println("Label verification PASSED!");
        }else {
            System.out.println("Label verification FAILED!");
        }


        // 4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotPasswordLink = "Forgot your password?";
        String actualForgotPasswordLink = forgotPasswordLink.getText();

        if (actualForgotPasswordLink.equals(expectedForgotPasswordLink)){
            System.out.println("Forgot password link verification PASSED!");
        } else {
            System.out.println("actualForgotPasswordLink = " + actualForgotPasswordLink);
            System.out.println("expectedForgotPasswordLink = " + expectedForgotPasswordLink);
            System.out.println("Forgot password link verification FAILED!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref = "forgot_password=yes";
        String actualInHrefAttributeValue = forgotPasswordLink.getAttribute("href");

        System.out.println("actualInHrefAttributeValue = " + actualInHrefAttributeValue);

        if (actualInHrefAttributeValue.contains(expectedInHref)){
            System.out.println("HREF attribute value verification PASSED!");
        }else {
            System.out.println("HREF attribute value verification FAILED!");
        }

         }
}
