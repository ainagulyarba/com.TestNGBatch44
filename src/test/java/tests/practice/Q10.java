package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.TestBase;

import java.security.Key;
import java.sql.Driver;

public class Q10 extends TestBase {

   // twitter a faker class kullanarak kayit olmaya calisiniz
@Test
    public void test() throws InterruptedException {

    driver.get("https://www.twitter.com");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//span[text()='Accepter tous les cookies']")).click();
    driver.findElement(By.xpath("//a[@data-testid='signupButton']")).click();
    Thread.sleep(2000);
    Faker faker=new Faker();
    driver.findElement(By.xpath("//span[text()='Utiliser un email']")).click();
    driver.findElement(By.xpath("//input[@name='name']")).click();

    Actions actions=new Actions(driver);
    actions.sendKeys(faker.name().fullName())
           .sendKeys(Keys.TAB)
           .sendKeys(faker.internet().emailAddress())
           .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
            .sendKeys(Keys.ARROW_DOWN).sendKeys("Mai").sendKeys(Keys.TAB)
           .sendKeys("15").sendKeys(Keys.TAB)
            .sendKeys(Keys.ARROW_DOWN).sendKeys("1976")
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ENTER)
            .sendKeys(Keys.SPACE)
            .perform();








   /* driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[1]")).click();




    WebElement aylar=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
    Select selectAylar=new Select(aylar);
    selectAylar.selectByIndex(faker.random().nextInt(1,12));
    WebElement gunler=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
    Select selectGunler=new Select(gunler);
    selectGunler.selectByVisibleText("10");
    WebElement yillar=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
    Select selectYillar=new Select(yillar);
    selectYillar.selectByVisibleText("2013");
    driver.findElement(By.xpath("//span[text()='Suivant']")).click();
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();

*/







}


}
