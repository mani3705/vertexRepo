import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectClasses.HomePage;
import pageObjectClasses.LoginPage;
import pageObjectClasses.TrainingPage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestVertex extends Base {
    private HomePage homePage;
    private TrainingPage trainingPage;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        driver.get("https://www.vertexinc.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 0)
    public void testHomePageTitle() {
        Assert.assertTrue(driver.getTitle().equals("Homepage | Vertex, Inc."));
    }

    @Test(dependsOnMethods = "testHomePageTitle")
    public void testGlobalDirectoryButtonDropdown() {
        Assert.assertEquals("Global Directory", homePage.getButtonGlobalDirectory().getText());
    }

    @Test(priority = 3)
    public void testClickOnTraining() {
        homePage.getTraining().click();

    }

    @Test(dependsOnMethods = "testClickOnTraining")
    public void testTrainingPage() {
        trainingPage.getCourses().click();
    }

    @Test
    public void testLoginPage() throws InterruptedException {
        homePage.getLogin().click();
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        System.out.println(set.size());
        String mainWindow = it.next();
        homePage.getLogin().click();

        while(it.hasNext()) {
            String loginWindow = it.next();
            if(!mainWindow.equals(loginWindow)) {
                driver.switchTo().window(loginWindow);
                driver.manage().window().maximize();
                System.out.println(driver.getTitle());
                loginPage.getUserName().sendKeys("user123");
                loginPage.getPassword().sendKeys("abcd");
                loginPage.getSubmit().click();
            }
        }

        driver.switchTo().window(mainWindow);
    }
}
