import Pages.AdminPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

import static java.lang.String.*;

public class taskLecture_4 extends BaseTest {
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
    private int _price;
    private int _quantity;
    private String _name;


    @BeforeMethod
    public void LoginToSite(){
        _prodPage = new LoginPage(_driver)
                .Login(_adminLogin, _adminPassword)
                .goToSubMenuPage(AdminPage.MainMenuLinks.Catalog, "товары", ProductsPage.class);

        _price = new Random().nextInt(100)+1;
        _quantity = new Random().nextInt(100)+1;
        _name = RandomStringUtils.randomAlphabetic(10);
    }

    @Test
    public void UserShouldBeAbleFillNewProductFormData(){
        _prodPage.goToAddProductForm()
                .setProductName(_name)
                .setProductQuantity(_quantity)
                .setProductPrice(_price)
                .saveProduct()
                .activateProduct()
                .closeNotificatoionMessage();
    }

    @Test
    public void CreatedProductShouldBeDisplayedInProductsList() throws Exception {
        _prodPage.goToAddProductForm()
                .fillAddProductForm(_name, _quantity, _price)
                .goToCatalog();

        Assert.assertTrue(_prodPage.isProdInCatalog(_name), "Product not found in catalog");

        _productFormPage =_prodPage._openProductDetails(_name);

        Assert.assertEquals(_productFormPage.getProductName(), _name);
        Assert.assertEquals(_productFormPage.getProductQnt(), _quantity);
        Assert.assertEquals(_productFormPage.getProductPrice(), _price);

    }
}
