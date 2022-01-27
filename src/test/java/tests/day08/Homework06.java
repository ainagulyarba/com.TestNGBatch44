package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework06 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void test1(){
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
      WebElement sayfadakiText= driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assert.assertTrue(sayfadakiText.isDisplayed());

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
     WebElement text=driver.findElement(By.xpath("//h3[text()='New Window']"));
      String actualNewTitle=text.getText();
      String expectedNewTitle="New Window";
      Assert.assertEquals(actualNewTitle,expectedNewTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        String expectedText="New Window";
        Assert.assertEquals(actualText,expectedText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.navigate().back();
        String actualSayfaBasligi=driver.getTitle();
        String expectedSayfaBasligi="The Internet";
        Assert.assertEquals(actualSayfaBasligi,expectedSayfaBasligi);

    }
@AfterClass
    public void tearDown(){

    driver.close();
}
}
