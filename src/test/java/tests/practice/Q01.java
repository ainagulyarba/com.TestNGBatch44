package tests.practice;

import org.testng.annotations.Test;

public class Q01 {

    /*
  ●TestNG (default ) olarak @Test methodları ni alfabetik sıraya gore run eder ..(Yukardan asagi degil)
  ●priority annotation Testlere öncelik vermek icin kullanilir, Kucuk olan Numara daha once calisir.
  priority:  TestNG testlerinde, testler konsola alfabetik sira ile yazdirilir.
   default degeri =0!!! priorityden once calisir
  enabled = false  methodu : Testi gormezden gelmek icin @Test in yanina    '(enabled = false)' fonksiyonunu kullaniriz.
 */

    @Test (priority =3000)
    public void b(){
        System.out.println("b");



    }

    @Test (priority = 2001, enabled = false) //ignor yapmak icin
    public void a(){
        System.out.println("a");



    }

    @Test(priority = 2000)
    public void c(){
        System.out.println("c");



    }
@Test
    public void test01(){


    System.out.println("Test 1 ...");
}

    @Test
    public void test02(){


        System.out.println("Test 2 ...");
    }
    @Test
    public void test03(){


        System.out.println("Test 3 ...");
    }
    @Test (enabled = false)
    public void test04(){


        System.out.println("Test 4 ...");
    }
    @Test (enabled = false)
    public void test05(){


        System.out.println("Test 5 ...");
    }
    @Test
    public void test06(){


        System.out.println("Test 6 ...");
    }




}
