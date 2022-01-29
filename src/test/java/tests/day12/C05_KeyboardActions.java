package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01(){

     //  1- Bir Class olusturalim KeyboardActions1
     //  2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
     //  3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       // aramaKutusu.sendKeys("samsung A71"); boyle de yapabiliriz
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu);
        actions.keyDown((Keys.SHIFT)).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).perform();

     //  4- aramanin gerceklestigini test edin





    }
}
