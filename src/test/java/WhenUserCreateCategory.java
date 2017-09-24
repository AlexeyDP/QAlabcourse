import Pages.CategoryPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WhenUserCreateCategory extends BaseTest {

    @BeforeMethod
    public void LoginToSite(){
        _adminPage = new LoginPage(_driver)
                .Login(_adminLogin, _adminPassword);
    }

    @Test
    public void draftTest(){
        CategoryPage page = new CategoryPage(_driver);
        page.goToCatalogSubMenu("категории");
        System.out.println(_driver.getTitle());
    }
}
