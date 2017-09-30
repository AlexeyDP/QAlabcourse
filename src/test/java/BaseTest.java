
import Pages.AdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    //Private
    private String driverPath = "C:\\Users\\1\\IdeaProjects\\QAlabcourse\\chromedriver.exe";

    //Protected
    protected WebDriver _driver;
    protected String _adminLogin = "webinar.test@gmail.com";
    protected String _adminPassword = "Xcg7299bnSmMuRLp9ITw";
    protected AdminPage _adminPage;


    @BeforeMethod
    public void Start(){
        //Create driver instance
        System.setProperty("webdriver.chrome.driver", driverPath);
        _driver = new ChromeDriver();

        //Configure _driver
        _driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        _driver.manage().window().maximize();
    }
    @AfterMethod
    public void End(){
        _driver.quit();
    }
}
