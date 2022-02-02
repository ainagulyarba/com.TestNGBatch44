package tests.Works;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.WeakHashMap;

public class Ifram extends TestBase {


    @Test
    public void test() throws InterruptedException {

//1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
//2. “Our Products” butonuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();

//3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        Thread.sleep(5000);

//4. Popup mesajini yazdirin
        WebElement popupMesaji=driver.findElement(By.xpath("//h4[@class='modal-title']"));
        System.out.println(popupMesaji.getText());

//5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

//6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='WebdriverUniversity.com (IFrame)']")).click();

//7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualWebAdres=driver.getCurrentUrl();
        String expectedWebAdres="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(actualWebAdres,expectedWebAdres,"adrese gidilmedi");

    }

}
