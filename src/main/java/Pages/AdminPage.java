package Pages;

import com.sun.javafx.collections.MappingChange;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AdminPage {
    private WebDriver _driver;

    private String getMenuID(String menuName) {
        Map menuLinkIds = new HashMap<String,String>();
        menuLinkIds.put("Заказы","subtab-AdminParentOrders");
        menuLinkIds.put("Каталог","subtab-AdminCatalog");
        menuLinkIds.put("Клиенты","subtab-AdminParentCustomer");
        menuLinkIds.put("Служба поддержки","subtab-AdminParentCustomerThreads");
        menuLinkIds.put("Статистика","subtab-AdminStats");
        menuLinkIds.put("Modules","subtab-AdminParentModulesSf");
        menuLinkIds.put("Design","subtab-AdminParentThemes");
        menuLinkIds.put("Доставка","subtab-AdminParentShipping");
        menuLinkIds.put("Способ оплаты","subtab-AdminParentPayment");
        menuLinkIds.put("International","subtab-AdminInternational");
        menuLinkIds.put("Shop Parameters","subtab-ShopParameters");
        menuLinkIds.put("Конфигурация","subtab-AdminAdvancedParameters");

        return (String) menuLinkIds.get(menuName);

    }
    public AdminPage(WebDriver driver){
        this._driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(className="employee_avatar_small")
    private WebElement _userIcon;
    @FindBy(id="header_logout")
    private WebElement _logoutLink;

    public void Logout(){
        _userIcon.click();
        _logoutLink.click();
    }


    public void ClickMenuLink(String linkName){

        _driver.findElement(By.id(getMenuID(linkName))).click();
    }






}
