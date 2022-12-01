package class01;

import org.testng.annotations.Test;

public class EnableDisable {
    @Test(enabled = false)
    public void Atest(){
        System.out.println("testinggg");
    }
    @Test
    public void Btest(){
        System.out.println("testinbbbb");
    }
    @Test
    public void Ctest(){
        System.out.println("See testing");
    }

}
