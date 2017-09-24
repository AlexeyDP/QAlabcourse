package Pages;

import Utils.WaitHelper;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CategoryPage extends AdminPage{
    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    private List<WebElement> _subMenuLinks;

    @FindBy(className="submenu")
    private WebElement _catalogSubMenu;


    private List<WebElement> get_subMenuLinks() {
        return _catalogSubMenu.findElements(By.xpath("./li/a"));
    }


    //draft implementation lecture 3 task
    public void goToCatalogSubMenu(String subMenuName){
        showSubMenu(MainMenuLinks.Catalog);
        //WaitHelper.WaitForVisible(_driver, _catalogSubMenu);
        WebElement subItem = null;
        for (WebElement subMenuItem: get_subMenuLinks()
             ) {
            if(subMenuItem.getText().equals(subMenuName)) subItem = subMenuItem;
        }
        if (subItem!=null)subItem.click();
        else System.out.println("Can not click subItem");

    }

}
