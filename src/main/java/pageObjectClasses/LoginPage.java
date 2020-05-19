package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By userName = By.xpath("//input[@id='rn_LoginForm_7_Username']");
    private By password = By.id("rn_LoginForm_7_Password");
    private By submit = By.cssSelector("input[value='Log In']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserName() {
        return driver.findElement(userName);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getSubmit() {
        return driver.findElement(submit);
    }
}
