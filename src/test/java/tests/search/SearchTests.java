package tests.search;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import validations.loader.Loader;
import validations.navbar.NavBar;
import validations.search.Search;
import validations.search.SearchResult;

public class SearchTests {
    NavBar navBar;
    Search search;
    SearchResult searchResult;
    Loader loader;

    public SearchTests(WebDriver driver) {
        navBar = new NavBar(driver);
        loader = new Loader(driver);
        search = new Search(driver);
        searchResult = new SearchResult(driver);
    }

    public void openSearchBar() {
        loader.waitForLoaderToGetInvisible();
        navBar.openSearchBar();
    }

    public void searchProduct(String productName) {
        search.searchAProduct(productName);
    }

    public void validateSearchedProductVisible(String productName) {
        boolean isSearchedProductVisible = searchResult.isSearchedProductVisible(productName);
        Assert.assertTrue(isSearchedProductVisible, "Searched product not visible");
    }
}
