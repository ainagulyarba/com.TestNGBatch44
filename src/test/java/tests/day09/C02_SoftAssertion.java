package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //    Yeni bir Class Olusturun : C03_SoftAssert
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
@Test
    public void test01(){
     //  1.“http://zero.webappsecurity.com/” Adresine gidin
    driver.get("http://zero.webappsecurity.com/");
//            2. Sign in butonuna basin
    driver.findElement(By.xpath("//button[@id='signin_button']")).click();
//  3. Login kutusuna “username” yazin
 WebElement  loginKutusu= driver.findElement(By.xpath("//input[@id='user_login']"));
    loginKutusu.sendKeys("username");
//  4. Password kutusuna “password” yazin
    WebElement  passwordKutusu= driver.findElement(By.xpath("//input[@id='user_password']"));
    passwordKutusu.sendKeys("password");
//  5. Sign in tusuna basin
    driver.findElement(By.xpath("//input[@value='Sign in']")).click();
//  6.Online Banking menusu altinda Pay Bills sayfasina gidin
    driver.navigate().back();// guvenli degil uyarisini geciyor
   driver.findElement(By.xpath("//a[@id='online-banking']")).click();
   driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

//  7. “Purchase Foreign Currency” tusuna basin
    driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();
//  8. “Currency” drop down menusunden Eurozone’u secin
WebElement currencyElementi=driver.findElement(By.xpath("//select[@id='pc_currency']"));
    Select select=new Select(currencyElementi);
    select.selectByValue("EUR");
//  9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    SoftAssert softassert=new SoftAssert();
    String actualSecim=select.getFirstSelectedOption().getText();
    String expectedSecim="Eurozone (euro)";
 softassert.assertEquals(actualSecim,expectedSecim,"Drop down dogru secilmedi");
//  10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
//  "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
//  "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
//  "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
List<WebElement> optionListesi=select.getOptions();
String actualOptionListesi="";
    for (WebElement each: optionListesi) {
        actualOptionListesi+="\""+each.getText()+"\",";
    }
    actualOptionListesi=actualOptionListesi.substring(0,actualOptionListesi.length()-1);
    String expectedOptionListesi="\"Select One\",\"Australia (dollar)\",\"Canada (dollar)\",\"Switzerland (franc)\",\"China (yuan)\",\"Denmark (krone)\",\"Eurozone (euro)\",\"Great Britain (pound)\",\"Hong Kong (dollar)\",\"Japan (yen)\",\"Mexico (peso)\",\"Norway (krone)\",\"New Zealand (dollar)\",\"Sweden (krona)\",\"Singapore (dollar)\",\"Thailand (baht)\"";
    softassert.assertEquals(actualOptionListesi,expectedOptionListesi,"option listesinin secenkleri testi calismadi");
    softassert.assertAll();

}


@AfterMethod
    public void tearDown(){
driver.close();

}

}
