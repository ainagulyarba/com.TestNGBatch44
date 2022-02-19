package tests.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Homework10 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        //      get the first window
        String windowHandleFirst = driver.getWindowHandle();
        Thread.sleep(3000);

        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='faktor-iframe-wrapper']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='mat-focus-indicator solo-button mat-button mat-button-base mat-raised-button']")).click();
        driver.switchTo().defaultContent();
        //      clicking on click here button
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //      get all the window in the set
        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String windowHandleSecond="";
        for (String each:windowHandlesSeti) {
            if (!each.equals(windowHandleFirst)){
                windowHandleSecond=each;
            }
        }
        // switch to window
        driver.switchTo().window(windowHandleSecond);
        //      input email id (somepne@gmail.com) and type something in that input
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com"+ Keys.ENTER);
        Thread.sleep(5000);
        //      verify title as expected
        String actualtitle = driver.getTitle();
        String expected="Guru99 Bank Home Page";
        Assert.assertEquals(actualtitle,expected);
        //      switch to first window
        driver.switchTo().window(windowHandleFirst);

        driver.quit();

    }
}
