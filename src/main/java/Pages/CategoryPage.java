package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends AdminPage{
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
    @FindBy(css = "div.alert.alert-success")
    private WebElement _alertSuccess;

    //Methods
    public CategoryPage sortAscending(FilterOption option){
        return this;
    }

    public CategoryPage sortDescending(FilterOption option){
        return this;
    }

    public CategoryPage addNewCategory(String categoryName)  {
        _addNewCategoryButton.click();
        _categoryNameInput.sendKeys(categoryName);
        _saveButton.click();
        return this;
    }

}


