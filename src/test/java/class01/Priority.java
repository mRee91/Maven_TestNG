package class01;

import org.testng.annotations.Test;

public class Priority {
    @Test(priority = 2)
    public void Atest(){
        System.out.println("Atest");
    }@Test
    public void Btest(){
        System.out.println("Btest");
    }@Test(priority = 1)
    public void Ctest(){
        System.out.println("Ctest");
    }
}
