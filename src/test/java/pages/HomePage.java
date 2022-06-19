package pages;

import com.demo.driver.DriverUtils;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {

    private final By lblTitle = By.id("com.goodreads:id/title");
    private final By pneWelcomeHeader = By.id("com.goodreads:id/feed_welcome_header");
    private final By lblSearchAction = By.id("com.goodreads:id/action_search");
    private final By txtSearch = By.id("com.goodreads:id/search_text");

    public boolean doesWelcomeHeaderDisplay() {
        return isVisible(pneWelcomeHeader);
    }

    public String getTitle() {
        return getText(lblTitle);
    }

    public void searchABook(String searchTerm) {
        waitForElementVisibility(lblSearchAction);
        click(lblSearchAction);
        waitForElementVisibility(txtSearch);
        enter(txtSearch, searchTerm);
        performSearch();
    }

    public void performSearch() {
        DriverUtils.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
    }
}
