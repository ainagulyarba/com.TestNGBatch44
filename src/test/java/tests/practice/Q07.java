package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;

public class Q07 extends TestBase {



@Test
    public void alertTesti1() throws InterruptedException {

    // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
    SoftAssert softAssert= new SoftAssert();

    driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
    Thread.sleep(2000);
     // 2. CLICK ME of JavaScript Alert e tıklayın
    driver.findElement(By.id("button1")).click();
    Thread.sleep(2000);
     // 3. pop up text i alın
    String message=driver.switchTo().alert().getText();

     // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
    String expectedMessage="I am an alert box!";
    softAssert.assertTrue(message.equals(expectedMessage));
    Thread.sleep(2000);
     // 5. pop up i kabul edin
    driver.switchTo().alert().accept();
    softAssert.assertAll();
    Thread.sleep(2000);

}
@Test (dependsOnMethods = "alertTesti1" )
    public void alertTesti2() throws InterruptedException {

    // Yine ayni class da baska test methodu olusturun
// 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
    SoftAssert softAssert= new SoftAssert();

    driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
    Thread.sleep(2000);

    // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
    driver.findElement(By.xpath("//span[@id='button4']")).click();
    Thread.sleep(2000);

    // 3.  pop up text i alın
    Alert alert=driver.switchTo().alert();
    String message=alert.getText();

    // 4. Mesajın "Press a button!" olduğunu doğrulayın
    String expectedMessage="Press a button!";
    softAssert.assertTrue(message.equals(expectedMessage));

    // 5. Açılır pencereyi kapat
    alert.dismiss();

    // 6. pop up i iptal edin,
    softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-alert-text']")).isDisplayed());
    softAssert.assertAll();

    // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin



}


 //   Alert alert=driver.switchTo().alert();
// alert variable ile ()'lara ulasilabilir
    //alert.dismiss();
    //alert.accept();



}
