package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingPage {
    private WebDriver driver;
    //private By courses = By.xpath("//a[contains(text(),'Explore All Courses')]");

    public TrainingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Explore All Courses')]")
    private WebElement courses;

    public WebElement getCourses(){ return courses;}

}
