package tests.day08.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {
       //    ● Tests package’inda yeni bir class olusturun: WindowHandle2

    WebDriver driver;

    @BeforeClass
public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void test(){

        //    ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
         WebElement sayfadakiYaziElementi= driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfadakiYaziElementi.getText(),"Opening a new window","sayfadaki yazi farkli");
        //    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(),"The Internet", "sayfa title'i beklenenden farkli" );
        String titleTheInternet=driver.getTitle();

        //    ● Click Here butonuna basın.
        //soruda WH degerini bilmedigim bir W aciliyor
        //o sayfanin W H degerini bulmak icin gectigim sayfalardaki
        //W H degerlerini kaydetmeliyim

        String windowHandleDegerei1= driver.getWindowHandle();
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        //    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        //once acilan yeni sayfanin handle degerini elde etmeliyim

        // once tum Handele degerlerini alip bir Set'e koyalim
        Set<String> handleDegerleriSeti=driver.getWindowHandles();
        String windowHandleDegeri2="";
        for (String each:handleDegerleriSeti) {
            if(!each.equals(handleDegerleriSeti)){
                windowHandleDegeri2=each;
            }
        }
        //artik yeni sayfaya gecis yapabilirim
        driver.switchTo().window(windowHandleDegeri2);
        softAssert.assertEquals(driver.getTitle(),"New Window","yeni sayfa title'i istenilenden farkli");
        //    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
       WebElement ikinciSayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
       softAssert.assertEquals(ikinciSayfadakiYaziElementi.getText(),"New Window","ikinci sayfadaki yazi istenenden farkli");
        //    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
driver.switchTo().window(windowHandleDegerei1);
softAssert.assertEquals(driver.getTitle(),"The Internet","Ilk sayfanin title'i beklenen gibi degil");
softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){

        driver.quit();

    }


}
