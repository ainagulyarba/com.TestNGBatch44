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

import java.time.Duration;
import java.util.List;

public class Homework11 {

    WebDriver driver;

    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
//   https://www.chanel.com/us/
    @Test
    public void test01(){

        driver.get("https://www.chanel.com/us/");
        //   1st test:

//           1- Accessing the site --> OK if the site is displayed

//           2- Click on the search bar (on the top menu)
            driver.findElement(By.xpath("(//button[@title='Search'])[2]")).click();
//           3- Search for "ROUGE ALLURE"
            WebElement arama=driver.findElement(By.xpath("//input[@type='search']"));
            arama.sendKeys("ROUGE ALLURE"+ Keys.ENTER);
//           3- Check if the items of the displayed list contain the searched word
            List<WebElement> liste=driver.findElements(By.xpath("//h4[@class='product-item__title heading is-7 is-cropped false']"));
             for (WebElement each:liste) {
            Assert.assertTrue(each.getText().contains("ROUGE ALLURE"),"kelimenin icerdigi testi basarisiz");
            }
        }
//           4- Select the second item of the list
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
//           2- Access to Makeup => Lipstick category (on top menu)
//           3- Click on ROUGE ALLURE product
//           4- Add the product to the cart
//           5- View Cart --> OK, if there is a "ROUGE ALLURE" product in the cart, the quantity=1 and the total cart is equal to the product price.


}

@AfterClass
    public void tearDown(){



}

}
