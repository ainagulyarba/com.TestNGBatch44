package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class jsd extends TestBase {

    @Test
            public void test() throws InterruptedException {


        driver.get("https://twitter.com/");
        driver.findElement(By.xpath("(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[5]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[6]")).click();

        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("//input[@autocomplete='name']"));
        isim.sendKeys(faker.name().name());
        driver.findElement(By.xpath("//span[.='E-posta kullan']")).click();
        WebElement email = driver.findElement(By.xpath("//input[@autocomplete='email']"));
        email.click();
        email.sendKeys(faker.internet().emailAddress());
        WebElement ay = driver.findElement(By.cssSelector("[id='SELECTOR_1']"));
        ;
        Select select = new Select(ay);
        select.selectByIndex(faker.random().nextInt(1, 12));
        WebElement gun = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
        ;
        Select select1 = new Select(gun);
        select1.selectByIndex(faker.random().nextInt(1, 30));
        WebElement yil = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
        ;
        Select select2 = new Select(yil);
        select2.selectByIndex(faker.random().nextInt(20, 90));
        driver.findElement(By.xpath("//span[.='İleri']")).click();

    }
}
