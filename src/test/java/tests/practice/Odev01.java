package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class Odev01  {
WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        //odev
        //soru :ingilizce
        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        //maximize the window
        driver.manage().window().maximize();
        //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();
        //if need use explicitly wait
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        WebElement textMesaji=driver.findElement(By.xpath("//div[@class='modal-body']"));
        Assert.assertTrue(textMesaji.isDisplayed());
        //click on the ok button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //accept the iframe message
        driver.switchTo().alert().accept();
        //1.soru :Turkce
        //web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
        // pencereyi büyüt
        // eylem diyalog düğmesine tıklayın
        // kullanmanız gerekiyorsa açıkça bekleyin
        // tamam butonuna tıklayın
        // iframe mesajını kabul et


    }
@AfterClass
    public void tearDown(){

driver.close();

}
}
