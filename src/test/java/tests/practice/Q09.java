package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q09 extends TestBase {

@Test
    public void test(){

    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html

    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
    // Fill in capitals by country.
    //capoital
    WebElement oslo=driver.findElement(By.xpath("//div[@id='box1']"));
    WebElement stokholm=driver.findElement(By.xpath("//div[@id='box2']"));
    WebElement washington=driver.findElement(By.xpath("//div[@id='box3']"));
    WebElement copenhagen=driver.findElement(By.xpath("//div[@id='box4']"));
    WebElement seoul=driver.findElement(By.xpath("//div[@id='box5']"));
    WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
    WebElement madrid=driver.findElement(By.xpath("//div[@id='box7']"));

    //country
    WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
    WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
    WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
    WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
    WebElement korea = driver.findElement(By.xpath("//div[@id='box105']"));
    WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
    WebElement unitedState = driver.findElement(By.xpath("//div[@id='box103']"));

    Actions actions=new Actions(driver);
    actions.dragAndDrop(oslo,norway)
            .dragAndDrop(stokholm,sweden)
            .dragAndDrop(washington,unitedState)
            .dragAndDrop(copenhagen,denmark)
            .dragAndDrop(seoul,korea)
            .dragAndDrop(rome,italy)
            .dragAndDrop(madrid,spain).perform();


}
















}
