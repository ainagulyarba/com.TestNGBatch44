package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {


    @Test
    public void nutellaTesti() throws IOException {

        //amazon anasayfasina gidelim
        driver.get("https://www.amazon.com");
        //nutella icin arama yapalilm
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // sonuclarini nutella icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucSayisiStr=sonucYazisiElementi.getText();
        Assert.assertTrue(sonucSayisiStr.contains("Nutella"));
        // testin calistigini ispati icin tum sayfanin screenshot'unu alalim
        //tum sayfa screenshot icin 4 adim gerekli
        //1. adim TakeScreenshot objesi olusturma
        TakesScreenshot tss=(TakesScreenshot) driver;
        //2. adim kaydedecegimiz dosyayi olusturalim
        File tumSayfaSS=new File("target/screenShot/tumsayfa.png");
        //3. adim bir dosya daha olusturup screeshot objesi ile screenshot'u alalim
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        //4.adim gecici resmi kaydetmek istedigimiz asil dosyaya copy yapalim
        FileUtils.copyFile(geciciResim,tumSayfaSS);










    }






}
