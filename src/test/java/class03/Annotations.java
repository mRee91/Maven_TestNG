package class03;

import org.testng.annotations.*;

public class Annotations { // Test this classs with Annotations xml
    @BeforeTest
    public void beforeTest() { System.out.println("beforeTest"); }

    @AfterTest
    public void afterTest() { System.out.println("afterTest"); }

    @BeforeClass
    public void BeforeClass(){ System.out.println("BeforeClass"); }

    @AfterClass public void AfterClass(){ System.out.println("AfterClass"); }

    @BeforeMethod
    public void beforeMethod() { System.out.println("beforeMethod"); }

    @AfterMethod
    public void afterMethod() { System.out.println("afterMethod"); }

    @Test
    public void AFirstTest(){ System.out.println("I am the first test"); }

    @Test
    public void BSecondTest(){ System.out.println("I am the second test"); }





}
