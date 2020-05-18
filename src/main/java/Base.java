import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    private Properties prop;
    protected WebDriver driver;
    private String path;
    public Base() {
         path =System.getProperty("user.dir");
        try {
            String uri = path+"\\src\\main\\resources\\data.properties";
            File file = new File(uri);
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(prop.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }


    }
}
