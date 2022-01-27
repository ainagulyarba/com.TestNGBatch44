package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void handleWindow() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String windowHandleDegereiBir=driver.getWindowHandle();
        System.out.println("ilk sayfanin Window Handle degeri : " + driver.getWindowHandle());
    driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencerede yeni bir pencere acilir
        String windowHandleDegereiIki=driver.getWindowHandle();
    driver.get("https://www.bestbuy.com");
        System.out.println("2.sayfanin Handle degeri = " + driver.getWindowHandle());

       Set<String> handleDegerleri = driver.getWindowHandles();
        System.out.println(handleDegerleri);

        Thread.sleep(5000);

       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.facebook.com");

        //amazon'un acik oldugu sayfaya gecin ve nutella icin arama yapin
        driver.switchTo().window(windowHandleDegereiBir);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //bestbuy acik olan sayfaya gecin ve title'in bestbuy icerdigini test edin
        Thread.sleep(2000);
        driver.switchTo().window(windowHandleDegereiIki);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        //facebook 'un acik oldugu sayfaya gecin ve URL in https://www.facebook.com/ oldugunu test edin
        // eger acik olan pencerelerden sadece bir tanesinin window handle degeri bilinmiyorsa
        // once tum handle degerlerini bulup bir set'e koyariz

        handleDegerleri=driver.getWindowHandles();
        //bu soru icin su anda Set'te 3 window handle degeri var
        //1. ve 2; sayfanin Window Handle degerlerini biliyoruz
        // Set'imizde olup ilk iki sayfa olmayan handle degeri 3. sayfanin handle degeri olacaktir

        String windowHandleDegeriUc="";
        for (String each: handleDegerleri) {
            if(!each.equals(windowHandleDegereiBir) || each.equals(windowHandleDegereiIki)){
                windowHandleDegeriUc=each;
            }

        }
        System.out.println("windowHandleDegeriUc = " + windowHandleDegeriUc);
        System.out.println("handleDegerleri = " + handleDegerleri);
        driver.switchTo().window(windowHandleDegeriUc);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        Thread.sleep(5000);

    }



@AfterClass
    public void tearDown(){

        driver.quit();
}


}
