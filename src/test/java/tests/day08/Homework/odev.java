package tests.day08.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class odev {

    //  ● Bir class oluşturun: C3_DropDownAmazon
 WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //  ● https://www.amazon.com/ adresine gidin.
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    //  - Test 1
    @Test
    public void test1(){
        //   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
   int actuelKategoriSayisi=driver.findElements(By.xpath("//*[@id='searchDropdownBox']")).size();
   int expectedKategoriSayisi=45;
        Assert.assertEquals(actuelKategoriSayisi,expectedKategoriSayisi);
    }

    //  -Test 2
    @Test
    public void test2(){
        //  1. Kategori menusunden Books secenegini  secin
       WebElement menu= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(menu);
        select.selectByVisibleText("Books");
        System.out.println("Books secenegi: " + select.getFirstSelectedOption().getText());

        //  2. Arama kutusuna Java yazin ve aratin
       WebElement javaYazisi= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox'] "));
       javaYazisi.sendKeys("Java"+Keys.ENTER);

        //  3. Bulunan sonuc sayisini yazdirin
       String sonucSayisi=driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText();
        System.out.println(sonucSayisi);

        //  4. Sonucun Java kelimesini icerdigini test edin
        String actuelKelime=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();

        System.out.println("actuelKelime = " + actuelKelime);

        Assert.assertTrue(actuelKelime.contains("Java"));



    }
@AfterClass
    public void tearDown(){

        //driver.close();
}






}
