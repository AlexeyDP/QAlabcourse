package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class AdminPage {
    // Private
    private WebDriver _driver;

    public enum MainMenuLinks{
        Orders("subtab-AdminParentOrders"),
        Catalog("subtab-AdminCatalog"),
        Customer("subtab-AdminParentCustomer"),
        CustomerSupport("subtab-AdminParentCustomerThreads"),
        Statistics("subtab-AdminStats"),
        Modules("subtab-AdminParentModulesSf"),
        Design("subtab-AdminParentThemes"),
        Shipping("subtab-AdminParentShipping"),
        PaymentMethod("subtab-AdminParentPayment"),
        International("subtab-AdminInternational"),
        ShopParameters("subtab-ShopParameters"),
        Configuration("subtab-AdminAdvancedParameters");

        private String linkName;

        MainMenuLinks(String menuName){this.linkName = menuName;}

        public String getLinkName() {
            return linkName;
        }
    }

    //Constructor
    public AdminPage(WebDriver driver){
        this._driver = driver;
        PageFactory.initElements(_driver, this);
    }

    //Elements
    @FindBy(className="employee_avatar_small")
    private WebElement _userIcon;
    @FindBy(id="header_logout")
    private WebElement _logoutLink;

    //Methods
    public void Logout(){
        _userIcon.click();
        _logoutLink.click();
    }

    public void ClickMenuLink(MainMenuLinks link){

        _driver.findElement(By.id(link.linkName)).click();
    }

}
