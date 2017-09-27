import Pages.AdminPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class taskLecture_2 extends BaseTest {

    /*
            Разработать скрипты в виде обычного приложения (с использованием метода main():
        o Скрипт А. Логин в Админ панель
        1. Открыть страницу Админ панели
        2. Ввести логин, пароль и нажать кнопку Логин.
        3. После входа в систему нажать на пиктограмме пользователя в верхнем
        правом углу и выбрать опцию «Выход.»
        o Скрипт Б. Проверка работоспособности главного меню Админ панели
        1. Войти в Админ панель (по аналогии с предыдущим скриптом)
        2. Кликнуть на каждом видимом пункте главного меню (Dashboard, Заказы,
        Каталог, Клиенты…) для открытия соответствующего раздела и выполнить
        следующее:
        a. Вывести в консоль заголовок открытого раздела.
        b. Выполнить обновление (рефреш) страницы и проверить, что
        пользователь остается в том же разделе после перезагрузки
        страницы.
    */


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
        _adminPage.clickMenuLink(linkName);
        System.out.println(_driver.getTitle());
        _driver.navigate().refresh();

        //Assert
        Assert.assertEquals(_driver.getTitle(), expectedPageTitle);
    }

}


