package tests.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Homework09 extends TestBase {
@Test
    public void test(){
    //      //   1- https://www.facebook.com adresine gidelim
    driver.get("https://www.facebook.com");
    driver.findElement(By.xpath("//button[@title='Tout accepter']")).click();
    //    2- Yeni hesap olustur butonuna basalim
    driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

    //    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    WebElement buttonName=driver.findElement(By.xpath("//input[@name='firstname']"));
    Actions actions=new Actions(driver);
    actions.click(buttonName).sendKeys("ainagul").sendKeys(Keys.TAB).
            sendKeys("yarba").sendKeys(Keys.TAB).
            sendKeys("aina@gmail.com").sendKeys(Keys.TAB).
            sendKeys("Valence").sendKeys(Keys.TAB).
            sendKeys("Valence").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
            sendKeys("12").sendKeys(Keys.TAB).
            sendKeys("nov").sendKeys(Keys.TAB).
            sendKeys("1986").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
            sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
            sendKeys(Keys.ENTER).perform();

}


}
