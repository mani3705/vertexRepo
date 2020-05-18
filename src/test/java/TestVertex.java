import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectClasses.HomePage;
import pageObjectClasses.TrainingPage;

import java.util.concurrent.TimeUnit;

public class TestVertex extends Base{
    private HomePage homePage;
    private TrainingPage trainingPage;

    @BeforeTest
    public void setUp(){
        driver.get("https://www.vertexinc.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
    }

    @Test(priority = 0)
    public void testHomePageTitle(){
        Assert.assertTrue(driver.getTitle().equals("Homepage | Vertex, Inc."));
    }

    @Test( dependsOnMethods = "testHomePageTitle")
    public void testGlobalDirectoryButtonDropdown(){
        Assert.assertEquals("Global Directory" , homePage.getButtonGlobalDirectory().getText());
    }

    @Test(priority = 3)
    public void testClickOnTraining(){
        homePage.getTraining().click();

    }

    @Test(dependsOnMethods = "testClickOnTraining")
    public void testTrainingPage(){
        trainingPage.getCourses().click();
    }
}
