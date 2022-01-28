package tests.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Q07 extends TestBase {


    @Test
    public void test(){
        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@title='Tout accepter']")).click();
        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement gunler=driver.findElement(By.xpath("//select[@id='day']"));
        Select selectGunler =new Select(gunler);
        List<WebElement> gunlerListesi=selectGunler.getOptions();
        for (WebElement each: gunlerListesi) {
            System.out.println("Gunler listesi = " + each.getText());
        }
        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN

        WebElement aylar=driver.findElement(By.xpath("//select[@id='month']"));
        Select selectAylar=new Select(aylar);
        List<WebElement> aylarListesi=selectAylar.getOptions();
        for (WebElement each:aylarListesi) {
            System.out.println("Aylar listesi = " + each.getText());
        }
        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement yillar=driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYillar=new Select(yillar);
        List<WebElement> yillarListesi=selectYillar.getOptions();
        for (WebElement each: yillarListesi) {
            System.out.println("Yillar listesi = " + each.getText());
        }


    }



}
