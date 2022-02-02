package tests.day09.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {

    //amazon.com anasayfasina gidip
    // sell linkine JSEecutor ile tiklayalim


    @Test
    public void test01() throws InterruptedException {

        driver.get("https:/www.amazon.com");

        //1-adim JSExecutor objesi olusturalim ve driver'i cast edelim
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //2-adim ilgili web elementi locate edelim
        WebElement sellelement=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        //3-adim ilgili script ve argument (bizim web elementimiz) ile objemiz uzerinden
        //executeScript ()'unu calistiralim
        jse.executeScript("arguments[0].click();",sellelement);//argument[0].click();-> kod parcacigi
        Thread.sleep(5000);

        //ilgili sayafaya gittigimizi test edelim
         WebElement yaziTesti=driver.findElement(By.xpath("//h2[text()='Sell on Amazon']"));
         Assert.assertTrue(yaziTesti.isDisplayed());

    }
}
