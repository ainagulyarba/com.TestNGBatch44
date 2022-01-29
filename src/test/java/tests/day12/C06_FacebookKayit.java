package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Watchable;
import java.security.Key;

public class C06_FacebookKayit extends TestBase {

    @Test
    public void test(){
    //   Yeni bir class olusturalim: D15_MouseActions4
    //   1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
    //   2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//button[@title='Tout accepter']")).click();
    //   3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
       WebElement adButonu= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        actions.click(adButonu).
                sendKeys("username").sendKeys(Keys.TAB).
                sendKeys("password").sendKeys(Keys.TAB).
                sendKeys("username@password").sendKeys(Keys.TAB).
                sendKeys("Valence").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("10").sendKeys(Keys.TAB).
                sendKeys("sep").sendKeys(Keys.TAB).
                sendKeys("2020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
               sendKeys(Keys.ENTER).perform();


    }



}
