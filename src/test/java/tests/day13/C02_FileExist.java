package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileExist {

@Test
    public void test01(){

    System.out.println( System.getProperty("user.home"));//C:\Users\AYN
    //masaustundeki deneme klasorunun path'ini istesem
    //C:\Users\AYN\Desktop\Deneme

    //yani dinamik olara masaustumdeki Deneme klasorunun path'ini yazmak istersem
    String path=System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";
    System.out.println(path);

    System.out.println( "user.dir : "+System.getProperty("user.dir"));
    //Masa ustunde Deneme klasoru icerisinde selenium.xlsx isminde bir dosya test edin
    //*************masa ustunde deneme klasoru ve icinde selenium.xlsx olmazsa CALISMAZ******
    //1-once bu dosyaya ulasmak icin gerekli dinamik path olusturalim
    String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";

    System.out.println(Files.exists(Paths.get(dosyaYolu)));

    //projemizde pom.xml oldugunu test edin
    //C:\Users\AYN\com.TestNGBatch44\pom.xml

    System.out.println(System.getProperty("user.dir"));// projemin yolunu verir

    String pomPath=System.getProperty("user.dir")+"\\pom.xml";
    Assert.assertTrue(Files.exists(Paths.get(pomPath)));


}












}
