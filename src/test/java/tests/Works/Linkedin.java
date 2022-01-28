package tests.Works;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Scanner;

public class Linkedin extends TestBase {

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.google.com");
      //  driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("linkedin ainagul yarba"+ Keys.ENTER);
        driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='cta-modal__dismiss-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@action-type='ACCEPT']")).click();
        driver.findElement(By.xpath("//a[@class='nav__button-secondary']")).click();
        Scanner scan=new Scanner(System.in);
        String username = scan.next();
        String password = scan.next();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");




    }







}
