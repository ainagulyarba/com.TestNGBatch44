package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(a,b,"bu 1.test basarisiz");//failed
        softAssert.assertTrue(a>b,"bu 2.test basarisiz");//failed
        softAssert.assertTrue(a<c);//passed
        softAssert.assertTrue(c>b);//passed
        softAssert.assertTrue(c<a,"bu 5.test basarisiz");//failed

        //assertAll demezsek class calisir ve passed yazar, cunku aslinda raporlama yapmaz
        // sadece kodlar calismis olur
        softAssert.assertAll();


    }
}
