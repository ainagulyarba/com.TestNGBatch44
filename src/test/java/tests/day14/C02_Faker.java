package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void facebookKayitTesti() throws InterruptedException {
        //   "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@title='Tout accepter']")).click();
        //   “create new account”  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //   “firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(isimKutusu)
                .sendKeys(faker.name().name())
        //   “surname” giris kutusuna bir soyisim yazin
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
        //   “email” giris kutusuna bir email yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
        //   “email” onay kutusuna emaili tekrar yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
        //   Bir sifre girin
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
        //   Tarih icin gun secin
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
        //   Tarih icin ay secin
                .sendKeys("sep")
                .sendKeys(Keys.TAB)
        //   Tarih icin yil secin
                .sendKeys("2020")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
        //   Cinsiyeti secin
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //   Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
         WebElement kadinSecim=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekSecim=driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertTrue(kadinSecim.isSelected());
       Assert.assertFalse(erkekSecim.isSelected());
        //   Sayfayi kapatin


        Thread.sleep(5000);


    }







}
