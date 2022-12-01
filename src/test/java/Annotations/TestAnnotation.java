package Annotations;

import org.testng.annotations.*;

public class TestAnnotation {
    @BeforeTest
    public void beforeTest() { System.out.println("beforeTest"); }
    @AfterTest
    public void afterTest() { System.out.println("afterTest"); }














    @BeforeClass
    public void beforeClass() { System.out.println("beforeClass"); }
    @AfterClass
    public void afterClass() { System.out.println("afterClass"); }


    @BeforeMethod
    public void beforeMethod() { System.out.println("beforeMethod"); }
    @AfterMethod
    public void afterMethod() { System.out.println("afterMethod"); }









}
