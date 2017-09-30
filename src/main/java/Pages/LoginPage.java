package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage {
    // Private
    private EventFiringWebDriver _driver;
    private String siteUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    //Constructor
    public  LoginPage(EventFiringWebDriver driver){
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
