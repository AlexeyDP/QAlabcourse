package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utils.WaitHelper.*;

public class ProductsPage extends AdminPage {
    //Constructor
    ProductsPage(WebDriver driver){super(driver);}

    //Elements
    @FindBy(id="page-header-desc-configuration-add")
    private WebElement _addProductButton;


    //Methods
    public NewProduct goToAddProductForm(){
        _addProductButton.click();
        WaitAjax(_driver);
        return new NewProduct(_driver);
    }
}
