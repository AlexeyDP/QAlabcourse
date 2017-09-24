import Pages.AdminPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WhenUserLoginToSite extends BaseTest {

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


