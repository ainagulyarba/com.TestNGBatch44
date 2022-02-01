package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {
    @Test
    public void screenTest(){

    driver.get("https://google.com");
    driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();

        //1.adim: screenshot almak icin obje olusturalim ve deger olarak driver'imizi atayalim
        // deger olarak driver'i kabul etmesi icin casting yapmamiz gerekir
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;//casting yapiyoruz cunku Takescreenshot bir interface'tir

        // 2.adim : tum sayfanin screenshot'ini almak icin bir File olusturalim ve Dosya yolunu belirtelim
        File tumSayfaSS=new File("src//tumSayfa.png");

        // 3.adim :  olusturdugumuz file ile tekeScreeshort objesini iliskilendirelim
        tumSayfaSS=takesScreenshot.getScreenshotAs(OutputType.FILE);

        // eger spesifik bir webelementin screenshot'ini almak istiyorsaniz
        WebElement logeElementi=driver.findElement(By.xpath("//img[@alt='Google']"));
        File logorResmi=new File("src/logo.png");
        logorResmi=logeElementi.getScreenshotAs(OutputType.FILE);

}


}
