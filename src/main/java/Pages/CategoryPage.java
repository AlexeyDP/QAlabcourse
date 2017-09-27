package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends AdminPage{
    public CategoryPage(WebDriver driver) {super(driver);
    }

    public enum FilterOption{
        ID("ID"),
        Name("Имя"),
        Position("Позиция");

        private String linkName;

        FilterOption(String filterName){this.linkName = filterName;}
    }

    //Elements
    @FindBy(id="page-header-desc-category-new_category")
    private WebElement _addNewCategoryButton;

    @FindBy(className ="nodrag nodrop")
    private WebElement _filterHeader;

    @FindBy(id="name_1")
    private WebElement _categoryNameInput;

    @FindBy(id="category_form_submit_btn")
    private WebElement _saveButton;
//    @FindBy(css = "div.alert.alert-success")
//    private WebElement _alertSuccess;

    private WebElement _filterOption(FilterOption option){
        return _driver.findElement(By.xpath(String.format("//th/span[contains(text(),'%1$s')]",option.linkName)));
    }

    //Methods
    public CategoryPage sortAscending(FilterOption option){
        _filterOption(option).findElement(By.xpath("./a[2]")).click();
        return this;
    }

    public CategoryPage sortDescending(FilterOption option){
        _filterOption(option).findElement(By.xpath("./a[1]")).click();
        return this;
    }

    public CategoryPage addNewCategory(String categoryName)  {
        _addNewCategoryButton.click();
        _categoryNameInput.sendKeys(categoryName);
        _saveButton.click();
        return this;
    }

}


