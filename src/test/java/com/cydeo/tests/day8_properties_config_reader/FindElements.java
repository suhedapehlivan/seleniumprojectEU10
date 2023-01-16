package com.cydeo.tests.day8_properties_config_reader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class FindElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.openxcell.com ");
        List<WebElement> list1 = driver.findElements(By.tagName("a"));
        System.out.println("list1.size() = " + list1.size());

        int count = 0;
        for (WebElement each : list1) {
            if (!(each.getText().isEmpty())) {
                System.out.println("each.getText() = " + each.getText());
                count++;
                // System.out.println("each.getAttribute(\"href\") = " + each.getAttribute("href"));
            }
        }
        System.out.println("count = " + count);
    }
}
