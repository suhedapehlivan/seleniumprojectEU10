package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {
    @Test
    public void circle_drap_drop_test(){
        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //locate "Accept Cookies" button and click
        WebElement cookies = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();

        //Locate small and big circles to be able to drag them around
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        // 2. Drag and drop the small circle to bigger circle.
        Actions actions= new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(bigCircle)
                .pause(2000)
                .release()
                .perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actual = bigCircle.getText();
        String expected= "You did great!";
        Assert.assertEquals(actual,expected);
    }
}
