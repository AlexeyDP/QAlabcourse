package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utils.WaitHelper.WaitAjax;

public class ProductsPage extends AdminPage {
    //Constructor
    public ProductsPage(WebDriver driver){super(driver);}

    private By _prodNameRowInListXpath = By.xpath("./td[3]/a");
    //Elements
    @FindBy(id="page-header-desc-configuration-add")
    private WebElement _addProductButton;

    @FindBy(css = "tbody > tr")
    private List<WebElement> _prodList;

    //Methods
    public NewProduct goToAddProductForm(){
        _addProductButton.click();
        WaitAjax(_driver);
        return PageFactory.initElements(_driver, NewProduct.class);
    }

    public boolean isProdInCatalog(String _prodName){
        for (WebElement row: _prodList
             ) {
            if(row.findElement(_prodNameRowInListXpath).getText().equals(_prodName)){
                return true;
            }
        }
        return false;
    }

    public NewProduct _openProductDetails(String prodName) throws Exception {

        for (WebElement row: _prodList
                    ) {
                if(row.findElement(_prodNameRowInListXpath).getText().equals(prodName)){
                    row.findElement(_prodNameRowInListXpath).click();
                    WaitHelper.WaitAjax(_driver);
                    return PageFactory.initElements(_driver, NewProduct.class);
                }
            }
            throw new Exception(String.format("Product with name %1$s not found in list", prodName));
    }
}
