package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    @Test
    public void FirstTestCase(){ //methods execute according to alphabetical order
        System.out.println("I am your first test case");
    }

    @Test
    public void SecondTestCase(){
        System.out.println("I am the second");
    }

    @Test
    public void ThirdTestCase(){
        System.out.println("I am three");
    }

    @BeforeMethod
    public void  beforeMethod() { // before methods run before every other @Test method
        System.out.println("i am a before method");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("Im the after method");
    }


}
