package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q02 {
WebDriver driver;

   @BeforeClass
    public void setUp() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
 //   birbirine bagimli testler olusturun..
 //  .beforClass olusturup setUp ayarlarini yapin..
 //  birbirine bagimli testler olusturarak;
       @Test(dependsOnMethods = "googleTesti")
               public void amazonTesti(){
           driver.get("http://www.amazon.com");

       }

    @Test(dependsOnMethods = "facebookTesti")
    public void googleTesti(){
        driver.get("http://www.google.com");

    }

    @Test
    public void facebookTesti(){
        driver.get("http://www.facebook.com");



    }

 //    ilk once facebook a gidin

 //    sonra facebook a bagimli olarak google a gidin,
 //    daha sonra google a bagimli olarak amazon a gidin
 //  driver i kapatin





    @AfterClass
    public void tearDown(){

driver.close();


    }












}
