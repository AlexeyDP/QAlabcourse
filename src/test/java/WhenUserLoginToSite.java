import Pages.AdminPage;
import Pages.LoginPage;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(JUnitParamsRunner.class)
public class WhenUserLoginToSite {

    //fields
    private LoginPage _loginPage;
    private AdminPage _adminPage;
    private WebDriver _driver;
    private String driverPath = "C:\\Users\\Obozhko\\.nuget\\packages\\selenium.chrome.webdriver\\2.31.0\\driver\\chromedriver.exe";

    //Before, After
    @Before
    public void Start(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        _driver = new ChromeDriver();
        _driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        _driver.manage().window().maximize();
    }
    @After
    public void End(){
        _driver.quit();
    }

    //Tests
    @Test
    @Parameters({"webinar.test@gmail.com, Xcg7299bnSmMuRLp9ITw" })
    public void AdminPageShouldBeOpenedIfCredentialsAreCorrect(String email, String password){
        _adminPage = new LoginPage(_driver)
                .Login(email, password);
        _adminPage.Logout();
    }

    @Test
    @Parameters({"Заказы, Заказы • prestashop-automation",
                "Каталог, товары • prestashop-automation",
                "Клиенты, Управление клиентами • prestashop-automation",
                "Служба поддержки, Customer Service • prestashop-automation",
                "Статистика, Статистика • prestashop-automation",
                "Modules, prestashop-automation",
                "Доставка, Курьеры • prestashop-automation",
                "Способ оплаты, Payment Methods • prestashop-automation",
                "International, Локализация • prestashop-automation",
                "Shop Parameters, General • prestashop-automation",
                "Конфигурация, Information • prestashop-automation",
    })
    public  void AdminShouldBeAbleToNavigateBetweenMenuLinks(String menuLinkName, String expectedPageTitle){
        //Arrange
        _adminPage = new LoginPage(_driver)
                .Login("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");

        //Actions
        _adminPage.ClickMenuLink(menuLinkName);
        System.out.println(_driver.getTitle());
        _driver.navigate().refresh();

        //Assert
        Assert.assertEquals(expectedPageTitle, _driver.getTitle());
    }


}
