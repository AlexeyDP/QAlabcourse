package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static Utils.WaitHelper.*;
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

    //Setters
    public NewProduct setProductName(String name){
        _productNameInput.sendKeys(name);
        return this;
    }
    public NewProduct setProductQuantity(int quantity){
        _productQuantityInput.sendKeys(valueOf(quantity));
        return this;
    }
    public NewProduct setProductPrice(int price){
        _productPriceInput.sendKeys(valueOf(price));
        return this;
    }

    public NewProduct saveProduct(){
        _saveProductButton.click();
        return this;
    }

    public NewProduct activateProduct(){
        Actions actions = new Actions(_driver);
        actions.sendKeys(Keys.chord(Keys.CONTROL, "O")).perform();
        WaitAjax(_driver);
        return this;
    }
}
