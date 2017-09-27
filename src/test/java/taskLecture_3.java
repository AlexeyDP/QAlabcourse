import Pages.CategoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.AdminPage.MainMenuLinks.Catalog;
import static Pages.CategoryPage.*;

public class taskLecture_3 extends BaseTest {

    @BeforeMethod
    public void LoginToSite(){
        _adminPage = new LoginPage(_driver)
                .Login(_adminLogin, _adminPassword);
    }

    @Test
    public void draftTest() {
        _adminPage.goToSubMenuPage(Catalog, "категории", CategoryPage.class)
                .addNewCategory("someName")
                .sortAscending(FilterOption.Name);
    }
}
