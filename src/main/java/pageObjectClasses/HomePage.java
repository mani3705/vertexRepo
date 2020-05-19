package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By buttonGlobalDirectory = By.xpath("//button[@id='reveal-menu-button-0']");
    private By training = By.xpath("//div[@class='site-header__utility__inner']//a[text()='Training']");
    private By login = By.xpath("//div[@class='site-header__utility__inner']//a[text()='myVertex']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonGlobalDirectory() {
        return driver.findElement(buttonGlobalDirectory);
    }

    public WebElement getTraining() {
        return driver.findElement(training);
    }

    public WebElement getLogin(){
        return driver.findElement(login);
    }


}
