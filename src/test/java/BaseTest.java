import Pages.AdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver _driver;
    private String driverPath = "C:\\Users\\1\\IdeaProjects\\QAlabcourse\\chromedriver.exe";
    protected String _adminLogin = "webinar.test@gmail.com";
    protected String _adminPassword = "Xcg7299bnSmMuRLp9ITw";
    protected AdminPage _adminPage;

    @BeforeMethod
    public void Start(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        _driver = new ChromeDriver();
        _driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        _driver.manage().window().maximize();
    }
    @AfterMethod
    public void End(){
        _driver.quit();
    }
}
