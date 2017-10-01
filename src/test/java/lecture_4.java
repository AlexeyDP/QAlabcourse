import Pages.AdminPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class lecture_4 extends BaseTest {
    /*
            Часть А. Создание продукта:
        1. Войти в Админ Панель.
        2. Выбрать пункт меню Каталог -> повары и дождаться загрузки страницы продуктов.
        3. Нажать «Новый товар» для перехода к созданию нового продукта, дождаться загрузки
        страницы.
        4. Заполнить следующие свойства нового продукта: Название продукта, Количество, Цена.
        Свойства продукта должны генерироваться случайно (случайное название продукта,
        количество от 1 до 100, цена от 0.1 ₴ до 100 ₴).
        5. После заполнения полей активировать продукт используя переключатель на нижней
        плавающей панели. После активации продукта дождаться всплывающего уведомления
        о сохранении настроек и закрыть его.
        6. Сохранить продукт нажав на кнопку «Сохранить». Дождаться всплывающего
        уведомления о сохранении настроек и закрыть его.
        Часть Б. Проверка отображения продукта:
        1. Перейти на главную страницу магазина.
        2. Перейти к просмотру всех продуктов воспользовавшись ссылкой «Все товары».
        Добавить проверку (Assertion), что созданный в Админ Панели продукт отображается на
        странице.
        3. Открыть продукт. Добавить проверки, что название продукта, цена и количество
        соответствует значениям, которые вводились при создании продукта в первой части
        сценария.
         Настройте выполнение тестового скрипта таким образом, чтобы при вызове выполнения
        тестов (mvn test) он выполнился на разных браузерах: Chrome, Firefox, Internet Explorer. Для
        этого можно в testng.xml воспользоваться возможностью передачи параметров.
         Дополнительное задание по желанию. Можно подключить ReportNG для генерации
        удобных отчетов. Для этого воспользуйтесь информацией с официального сайта
        http://reportng.uncommons.org/ и следующей инструкцией:
        https://solidsoft.wordpress.com/2011/01/23/better-looking-html-test-reports-for-testng-withreportng-maven-guide/
     */

    @BeforeMethod
    public void LoginToSite(){
        _adminPage = new LoginPage(_driver)
                .Login(_adminLogin, _adminPassword);

    }

    //draft, does not work yet
    @Test
    public void UserShouldBeAbleFillNewProductFormData(){
        _adminPage.goToSubMenuPage(AdminPage.MainMenuLinks.Catalog, "товары", ProductsPage.class)
                .goToAddProductForm()
                .setProductName("SomeName")
                .setProductQuantity(1)
                .setProductPrice(100)
                .saveProduct()
                .activateProduct();
    }
}
