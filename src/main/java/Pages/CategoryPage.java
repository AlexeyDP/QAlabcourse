package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Utils.WaitHelper.WaitForVisible;

public class CategoryPage extends AdminPage{
    public CategoryPage(WebDriver driver) {super(driver);
    }

    public enum CategoryListField{
        ID(2),
        Name(3),
        Description(4),
        Position(5),
        IsShow(6);

        private int fieldNumber;

        CategoryListField(int fieldNumber){this.fieldNumber = fieldNumber;}
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

    @FindBy(css = "div.alert.alert-success")
    private WebElement _alertSuccess;

    @FindBy(css = "#table-category > tbody > tr")
    private List<WebElement> _categoryList;

    private WebElement _filterOption(CategoryListField field){
        return _driver.findElement(By.cssSelector(String.format("#table-category > thead >tr> th:nth-child(%1$s)",field.fieldNumber)));
    }

    /* search in category list web element which has 'value' in field 'byField' and return true if found */
    public boolean isCategoryInList(CategoryListField byField, String value){
        for (WebElement row: _categoryList
             ) {
            if(row.findElement(By.xpath(String.format("./td[%1$s]", byField.fieldNumber))).getText().equals(value)){
                return true;
            }
        }
        return false;
    }

    //Methods
    public CategoryPage sortAscending(CategoryListField field){
        _filterOption(field).findElement(By.xpath(".//a[2]")).click();
        return this;
    }

    public CategoryPage sortDescending(CategoryListField field){
        _filterOption(field).findElement(By.xpath(".//a[1]")).click();
        return this;
    }

    public CategoryPage addNewCategory(String categoryName)  {
        _addNewCategoryButton.click();
        _categoryNameInput.sendKeys(categoryName);
        _saveButton.click();
        WaitForVisible(_driver, _alertSuccess, 5);

        return this;
    }

}


