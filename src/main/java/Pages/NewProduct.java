package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WaitHelper.*;
import static java.lang.Integer.parseInt;
import static java.lang.String.*;

public class NewProduct extends ProductsPage{
    //Constructor
    public NewProduct(WebDriver driver){super(driver);}

    //Elements

    @FindBy(id="form_step1_name_1")
    private WebElement _productNameInput;

    @FindBy(id="form_step1_qty_0_shortcut")
    private WebElement _productQuantityInput;

    @FindBy(id="form_step1_price_shortcut")
    private WebElement _productPriceInput;

    @FindBy(id="submit")
    private WebElement _saveProductButton;

    @FindBy(id="growls")
    private WebElement _alertMessage;

    @FindBy(css = "#growls > div > div.growl-close")
    private WebElement __closeMessage;

    //Setters
    public NewProduct setProductName(String name){
        _productNameInput.clear();
        _productNameInput.sendKeys(name);
        return this;
    }
    public NewProduct setProductQuantity(int quantity){
        _productQuantityInput.clear();
        _productQuantityInput.sendKeys(valueOf(quantity));
        return this;
    }
    public NewProduct setProductPrice(int price){
        _productPriceInput.clear();
        _productPriceInput.sendKeys(valueOf(price));
        return this;
    }

    public NewProduct saveProduct(){
        _saveProductButton.click();
        return this;
    }

    //Getters
    public String getProductName(){
       return  _productNameInput.getAttribute("value");
    }
    public int getProductPrice(){
        return parseInt(_productPriceInput.getAttribute("value").split(",")[0]);
    }

    public int getProductQnt(){
        return parseInt(_productQuantityInput.getAttribute("value"));
    }

    //Methods
    public NewProduct activateProduct(){
        Actions actions = new Actions(_driver);
        actions.sendKeys(Keys.chord(Keys.CONTROL, "o")).perform();
        WaitAjax(_driver);
        return this;
    }

    public NewProduct closeNotificatoionMessage(){
        WaitHelper.WaitForVisible(_driver, _alertMessage, 3);
        (__closeMessage).click();
        return this;
    }

    public NewProduct fillAddProductForm(String prodName, int prodQnt, int prodPrice){
         setProductName(prodName)
        .setProductQuantity(prodQnt)
        .setProductPrice(prodPrice)
        .saveProduct()
        .activateProduct()
        .closeNotificatoionMessage();
        return this;
    }

    public ProductsPage goToCatalog(){
        Actions actions = new Actions(_driver);
        actions.sendKeys(Keys.chord(Keys.CONTROL, "q")).perform();
        WaitAjax(_driver);
        return PageFactory.initElements(_driver, ProductsPage.class);
    }
}
