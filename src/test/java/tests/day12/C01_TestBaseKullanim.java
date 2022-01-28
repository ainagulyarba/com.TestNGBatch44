package tests.day12;

import org.testng.annotations.Test;
import tests.day10.C01_Allerts;
import utilities.TestBase;

public class  C01_TestBaseKullanim extends TestBase{


    @Test
    public void test01(){
        // projeniz icerisindeki herhangi class'dan obje olusturabilir ve
        //o obje sayesinde ait oldugu class'daki tum variable ve ()'lara
        // (accesse modifiyer izin verdigi surece) ulasabilirim
        C01_Allerts obj=new C01_Allerts();

        //eger proje kapsaminda bir slass'dan obje olusturulmasini engelemek isterseniz
        //1- o class'in constructor'ini private yapabiliriz
       // 2- class'in kendisini abstract yapabiliriz
        //1.method cok tercih edilmez cunku OOP consept'e uymaz (cok sinirli sayida kullanimi vardir
        //2. method'u kullanabiliriz, boylece o class'daki abstackr olmayan(concrete)
        //()'lari ovveride etmek mecburiyeti olmadan kullanabiliriz
        // ama obje olusturamayiz
        // ornegin biz testBase class'ini abstract yaptigimizdan obje olusturamayiz
        //ama child class'lardan TestBase'deki setUp ve tearDown ()'larini kullanabiliriz

        //ornegin biz testBase
     TestBase obj1=new TestBase();




    }













}
