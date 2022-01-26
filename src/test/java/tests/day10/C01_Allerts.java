package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {


WebDriver driver;
WebElement sonucYazisiElementi;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @Test
    public void acceptAlertTesti() throws InterruptedException {
        //   ● Bir class olusturun: Alerts
//   ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//           ● Bir metod olusturun: acceptAlert
//       ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
//       “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);

    }

    @Test
    public void dismissAlertTesti() throws InterruptedException {
    //   ● Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    // “successfuly” icermedigini test edin.
driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
Thread.sleep(2000);
driver.switchTo().alert().dismiss();
 sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
String actualSonucYazisi=sonucYazisiElementi.getText();
String istenmeyenKelime="successfuly";
Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));


    }
    @Test
    public void sendKeysAllert() throws InterruptedException {
        //   ● Bir metod olusturun: sendKeysAlert
        // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,

driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
driver.switchTo().alert().sendKeys("Yildiz");
        Thread.sleep(2000);
     //OK butonuna tıklayın
driver.switchTo().alert().accept();
//     ve result mesajında isminizin görüntülendiğini doğrulayın.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String yazdigimizKelime="Yildiz";
        Assert.assertTrue(actualSonucYazisi.contains(yazdigimizKelime));

    }

    @AfterClass
    public void tearDown(){

        driver.close();


    }

}
