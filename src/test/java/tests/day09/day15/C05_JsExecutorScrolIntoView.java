package tests.day09.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecutorScrolIntoView extends TestBase {

//   1- Yeni bir class olusturun : ScroolInto
    @Test
    public void scroolAction() throws InterruptedException {
    //   2- hotelmycamp anasayfasina gidin
        driver.get("https:/www.hotelmycamp.com");
    //   3- 2 farkli test method’u olusturarak actions clasi ve
    //   Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

       driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]")).click();
Thread.sleep(5000);
    //   4- istediginiz oda inceleme sayfasi acildigini test edin


    }

@Test
    public void scroolJsExecutor() throws InterruptedException {
    driver.get("https:/www.hotelmycamp.com");
//1-adim JsExecutor objesi olustur ve driver'i cast et
    JavascriptExecutor jse=(JavascriptExecutor) driver;

//2-adim calisacagimiz web elementi locate edelim
    WebElement odaInceleLinki=driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

//3-adim ilgili script ve argument ile jse.executeScript() calistir
    jse.executeScript("arguments[0].scrollIntoView(true);",odaInceleLinki);
    Thread.sleep(5000);
    jse.executeScript("arguments[0].click();",odaInceleLinki);
    Thread.sleep(5000);
}


}
