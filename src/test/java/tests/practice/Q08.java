package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q08 extends TestBase {

   @Test
    public void test(){

// https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
       driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// web sitesini maximize yapin

// ikinci emojiye tıklayın
       WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
       driver.switchTo().frame(iframe);
    //   driver.switchTo().frame("emojis"); yukardaki iki satir yerine bu sekilde de kullanimi olur
       driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

// tüm ikinci emoji öğelerini tıklayın
      List<WebElement> emojiOgeler=driver.findElements(By.xpath("//div[@id='nature']/div/img"));
      for (WebElement each: emojiOgeler) {
         each.click();
      }
      // emojiOgeler.stream().forEach(x->x.click()); ->Lambda yontemi
      System.out.println("Ogeler tiklandi");

// parent iframe e geri donun
driver.switchTo().defaultContent();

// formu doldurun,(Formu istediğiniz metinlerle doldurun)
      List<WebElement> metinGirList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
   List<String> metinler=new ArrayList<>(Arrays.asList("Bir","iki","uc","dort","bes","alti","yedi","sekiz","dokuz", "",""));
      for (int i = 0; i < metinGirList.size() ; i++) {
         metinGirList.get(i).sendKeys(metinler.get(i));
      }

//  apply button a basin
driver.findElement(By.id("send")).click();


   }


}
