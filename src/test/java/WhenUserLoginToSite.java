import Pages.AdminPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

//@RunWith(JUnitParamsRunner.class)
public class WhenUserLoginToSite {

    //fields
    private LoginPage _loginPage;
    private AdminPage _adminPage;
    private WebDriver _driver;
    private String driverPath = "C:\\Users\\Obozhko\\.nuget\\packages\\selenium.chrome.webdriver\\2.31.0\\driver\\chromedriver.exe";
    private String _adminLogin = "webinar.test@gmail.com";
    private String _adminPassword = "Xcg7299bnSmMuRLp9ITw";

    //Before, After
    @BeforeMethod
    public void Start(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        _driver = new ChromeDriver();
        _driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        _driver.manage().window().maximize();
    }
    @AfterMethod
    public void End(){
        _driver.quit();
    }

    //Tests
    @Test
    public void AdminPageShouldBeOpenedIfCredentialsAreCorrect(){
        _adminPage = new LoginPage(_driver)
                .Login(_adminLogin, _adminPassword);
        _adminPage.Logout();
    }


    @DataProvider
    public Object[][] mainMenuTest(){
        return new Object[][]{
                {AdminPage.MainMenuLinks.Orders, "Заказы • prestashop-automation"},
                {AdminPage.MainMenuLinks.Catalog, "товары • prestashop-automation"},
                {AdminPage.MainMenuLinks.Customer, "Управление клиентами • prestashop-automation"},
                {AdminPage.MainMenuLinks.CustomerSupport, "Customer Service • prestashop-automation"},
                {AdminPage.MainMenuLinks.Statistics, "Статистика • prestashop-automation"},
                {AdminPage.MainMenuLinks.Modules, "prestashop-automation"},
                {AdminPage.MainMenuLinks.Design, "Шаблоны • prestashop-automation"},
                {AdminPage.MainMenuLinks.Shipping, "Курьеры • prestashop-automation"},
                {AdminPage.MainMenuLinks.PaymentMethod, "Payment Methods • prestashop-automation"},
                {AdminPage.MainMenuLinks.International, "Локализация • prestashop-automation"},
                {AdminPage.MainMenuLinks.ShopParameters, "General • prestashop-automation"},
                {AdminPage.MainMenuLinks.Configuration, "Information • prestashop-automation"}
        };
    }
    @Test(dataProvider = "mainMenuTest")
    public  void AdminShouldBeAbleToNavigateBetweenMenuLinks(AdminPage.MainMenuLinks linkName, String expectedPageTitle){
        //Arrange
        _adminPage = new LoginPage(_driver)
                .Login(_adminLogin, _adminPassword);

        //Actions
        _adminPage.ClickMenuLink(linkName);
        System.out.println(_driver.getTitle());
        _driver.navigate().refresh();

        //Assert
        Assert.assertEquals(_driver.getTitle(), expectedPageTitle);
    }

}


