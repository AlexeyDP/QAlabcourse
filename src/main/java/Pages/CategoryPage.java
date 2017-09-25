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

    public enum FilterSorting{
        UP,
        DOWN;
    }

    @FindBy(id="page-header-desc-category-new_category")
    private WebElement _addNewCategory;

    @FindBy(className ="nodrag nodrop")
    private WebElement _filterHeader;


    public void sortCategory(FilterOption by, FilterSorting order){}



}


