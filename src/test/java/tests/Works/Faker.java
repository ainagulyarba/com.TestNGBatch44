package tests.Works;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Faker extends TestBase {

    @Test
    public void test(){
        //linkedin e gidin
        driver.get("https://www.linkedin.com");
        //cookie'si click edin
        driver.findElement(By.xpath("(//button[@class='artdeco-global-alert-action artdeco-button artdeco-button--inverse artdeco-button--2 artdeco-button--primary'])[2]")).click();
        //isim kutusuna girin
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@autocomplete='username']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
       // String email=faker








    }






}
