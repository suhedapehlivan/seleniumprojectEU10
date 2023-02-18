package com.cydeo.tests.tasks;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Todo {
    @Test
    public void test() {
        Driver.getDriver().get("https://todomvc.com/");
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//div[text()='JavaScript']")).click();
        Driver.getDriver().findElement(By.xpath("//ul/li[8]/a[text()='Polymer']")).click();

        Faker faker = new Faker();

        WebElement toDO = Driver.getDriver().findElement(By.id("new-todo"));

        toDO.sendKeys(faker.animal().name()+ Keys.ENTER+faker.animal().name()+Keys.ENTER);

        WebElement secondItem = Driver.getDriver().findElement(By.xpath("//li[2]//div//label[@class='style-scope td-item']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(secondItem).perform();

        BrowserUtils.sleep(2);

        actions.doubleClick().perform();

        actions.sendKeys(faker.animal().name()).perform();
        actions.sendKeys(Keys.ENTER).perform();

        /*
        Actions actions = new Actions(driver);

        WebElement todo2= driver.findElement(By.xpath("(//label[@class='style-scope td-item'])[2]"));
        actions.doubleClick(todo2).perform();

        WebElement edit = driver.findElement(By.xpath("//input[@id='edit']"));
        edit.sendKeys(Keys.chord(Keys.CONTROL, "a")+ Keys.BACK_SPACE);
        //chord   bu method sayesinde 2 action aynı anda kullanılabiliyor

        todo.sendKeys("earth"+ Keys.ENTER);
         */




    }
}