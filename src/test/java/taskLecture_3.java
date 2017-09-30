import Pages.AdminPage;
import Pages.CategoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Pages.AdminPage.MainMenuLinks.Catalog;
import static Pages.CategoryPage.*;

public class taskLecture_3 extends BaseTest {

    /*
             Разработать скрипт в виде обычного приложения (с использованием метода main():
        1. Войти в Админ Панель
        2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления
        категориями.
        3. Нажать «Добавить категорию» для перехода к созданию новой категории.
        4. После загрузки страницы ввести название новой категории и сохранить изменения. На
        странице управления категориями должно появиться сообщение об успешном
        создании категории.
        5. Отфильтровать таблицу категорий по имени и дождаться там появления записи
        созданной категории.
        Примечания: В процессе разработки следует не забывать о том, что, возможно, потребуется
        описывать ожидания для корректной отработки скрипта (ожидание загрузки необходимой
        страницы и ее содержимого, ожидание видимости подпунктов главного меню после наведения
        курсора и т.п.)
        Для доступа в Админ Панель используйте следующие данные:
        Адрес: http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
        Логин: webinar.test@gmail.com
        Пароль: Xcg7299bnSmMuRLp9ITw
         Дополнительно необходимо описать логгер, который будет выводить в консоль базовые
        действия драйвера в процессе выполнения скрипт (переход на страницу, поиск элементов,
        клики по элементам). Самый простой способ описания логгера – использовать свою
        реализацию WebDriverEventListener
    */

    @BeforeMethod
    public void LoginToSite(){
        _adminPage = new LoginPage(_driver)
                .Login(_adminLogin, _adminPassword);
    }

    @DataProvider
    public Object[][] addCategoryTest(){
        return new Object[][]{
                {CategoryListField.Name, "Category for test"},
        };
    }

    @Test(dataProvider = "addCategoryTest")
    public void CategoryShouldBeInCategoryList(CategoryListField sortByFieldName, String categoryName) throws InterruptedException {
       //Actions
        boolean isCategoryInList =  _adminPage.goToSubMenuPage(Catalog, "категории", CategoryPage.class)
                .addNewCategory(categoryName)
                .sortAscending(sortByFieldName)
                .isCategoryInList(sortByFieldName, categoryName);

        //Assertions
        Assert.assertTrue(isCategoryInList);

    }
}
