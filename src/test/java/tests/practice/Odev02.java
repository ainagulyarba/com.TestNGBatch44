package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Odev02 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test() throws InterruptedException {
        //odev
        //2.soru :Ingilizce
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        //    accept Alert(I am an alert box!) and print alert on console
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        //    finally print on console this message "Hello TechproEducation How are you today"
        String message=driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(message);
        //2.soru:Turkce
        // url'ye gidin :http://demo.automationtesting.in/Alerts.html
        // "Alert with OK"yi tıklayın ve 'click the button to display a confirm box' i tıklayın:'
        // Uyarıyı kabul et(I am an alert box!) ve uyarıyı konsolda yazdır
        //  "Alert with OK & Cancel" ı tıklayın ve 'click the button to display a confirm box' i tıklayın
        // Uyarıyı iptal et (Press a Button !)
        // "Alert with Textbox" ı tıklayın ve 'click the button to demonstrate the prompt box' tıklayın'
        // ve ardından sendKeys 'TechProEducation' (Lütfen adınızı girin)
        // sonunda "Hello TechproEducation How are you today" mesajını konsola yazdır (modifié)


    }
   @AfterClass
    public void tearDown(){

//driver.close();


   }
}
