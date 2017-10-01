package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WaitHelper.WaitAjax;

public class ProductsPage extends AdminPage {
    //Constructor
    public ProductsPage(WebDriver driver){super(driver);}

    //Elements
    @FindBy(id="page-header-desc-configuration-add")
    private WebElement _addProductButton;


    //Methods
    public NewProduct goToAddProductForm(){
        _addProductButton.click();
        WaitAjax(_driver);
        return PageFactory.initElements(_driver, NewProduct.class);
    }
}
