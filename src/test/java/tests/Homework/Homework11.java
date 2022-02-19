package tests.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Homework11 extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.chanel.com/us/");
        //   1st test:

//           1- Accessing the site --> OK if the site is displayed
            WebElement site=driver.findElement(By.xpath("//img[@class='logo_header']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(site.isDisplayed(),"site is not displayed");
//           2- Click on the search bar (on the top menu)
            driver.findElement(By.xpath("(//button[@title='Search'])[2]")).click();
//           3- Search for "ROUGE ALLURE"
            WebElement arama=driver.findElement(By.xpath("//input[@type='search']"));
            arama.sendKeys("ROUGE ALLURE"+ Keys.ENTER);
//           3- Check if the items of the displayed list contain the searched word
            Thread.sleep(3000);
            List<WebElement> liste=driver.findElements(By.className("product-list-inline__link"));
             for (WebElement each:liste) {
            Assert.assertTrue(each.getText().contains("ROUGE ALLURE"),"kelimenin icerdigi testi basarisiz");
            }
        }
//           4- Select the second item of the list
         //   WebElement secondItem=driver.findElement(By.xpath("(//h4[@class='product-item__title heading is-7 is-cropped false'])[2]"));
//           5- Make sure that the displayed product name is the same as the previously selected name.

 //  Siteye erişim --> Site görüntüleniyorsa Tamam
 //   2- Arama çubuğuna tıklayın (üst menüde)
 //   3- "ROUGE ALLURE" için arama yapın
 //   3- Görüntülenen listedeki öğelerin aranan kelimeyi içerip içermediğini kontrol edin.
 //   4- Listenin ikinci öğesini seçin
 //   5- Görüntülenen ürün adının daha önce seçilen adla aynı olduğundan emin olun.

    @Test
    public void test02(){

    //   2nd test:
//           1- Access to the site
    driver.get("https://www.chanel.com/us/");
//           2- Access to Makeup => Lipstick category (on top menu)
        driver.findElement(By.xpath("(//span[text()='Makeup'])[1]")).click();

        driver.findElement(By.xpath("(//a[@data-event-action='lips'])[1]")).click();
//           3- Click on ROUGE ALLURE product
//           4- Add the product to the cart
//           5- View Cart --> OK, if there is a "ROUGE ALLURE" product in the cart, the quantity=1 and the total cart is equal to the product price.


}



}
