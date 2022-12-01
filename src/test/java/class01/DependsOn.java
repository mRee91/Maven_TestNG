package class01;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void Login(){
        System.out.println(10/0);
    }@Test(dependsOnMethods = {"Login"})
    public void DashboardVerification(){
        System.out.println("after logging in i will verify the dashboard");
    }
}
