package tests.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.Works.Faker;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homework12 extends TestBase {


    @Test
    public void test(){

        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
       driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        List<WebElement> tumOgelerListesi=driver.findElements(By.xpath("//div[@class='shelf-item']"));
        System.out.println("sitede "+tumOgelerListesi.size()+" urun var");
        List<WebElement> tumOgelerinIsmi=driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        for (int i = 0; i <tumOgelerinIsmi.size() ; i++) {
            System.out.println(i+1 +".urun: " + tumOgelerinIsmi.get(i).getText());
        }
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        ArrayList<String> urunAdlari=new ArrayList<>();
        for (int i = 0; i <tumOgelerinIsmi.size() ; i++) {
            urunAdlari.add(tumOgelerinIsmi.get(i).getText());
        }
        System.out.println("urunAdlari = " + urunAdlari);

        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın



        // (Her ürün 1 defadan fazla eklenemez!)
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        // 7.Checkout'a tıklayın


    }


}
