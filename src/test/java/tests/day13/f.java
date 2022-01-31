package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class f extends TestBase {

    @Test
    public void test(){

        // a. http://a.testaddressbook.com adresine gidiniz.
       driver.get("http://a.testaddressbook.com");
        // b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        // ii.Password : Test1234!
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testtechproed@gmail.com");
            driver.findElement(By.id("session_password")).sendKeys(" Test1234!");
            driver.findElement(By.xpath("//input[@type='submit']")).click();
        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).


        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        //3. Sayfada kac tane link oldugunu bulun.

        //5. driver i kapatin
        //
        //   driver.close();

    }




    }









