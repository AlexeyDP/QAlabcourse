package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // Private
    private WebDriver _driver;
    private String siteUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    //Constructor
    public  LoginPage(WebDriver driver){
        this._driver = driver;
        _driver.navigate().to(siteUrl);
        PageFactory.initElements(_driver, this);
    }

    //Elements
     @FindBy(id="email")
     private WebElement _emailInput;

     @FindBy(id="passwd")
     private  WebElement _paswwordInput;

     @FindBy(name="submitLogin")
     private WebElement _submitButton;

    //Methods
     public AdminPage Login(String userEmail, String userPassword){
         _emailInput.sendKeys(userEmail);
         _paswwordInput.sendKeys(userPassword);
         _submitButton.click();

         return new AdminPage(_driver);
     }
}
