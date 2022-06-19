package tests;

import com.demo.helpers.LogHelper;
import com.demo.utils.Constants;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;

public class TestCaseDemo extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final SearchResultPage searchResultPage = new SearchResultPage();

    @Test
    @Description("Marking the book as 'Want to Read'")
    public void TC01() {
        String bookDescription = "The Clearing by JJJJJerome Ellis";

        LogHelper.info("Step: Login to the app");
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);

        LogHelper.info("Step: Verify that login successfully");
        Assert.assertTrue(homePage.doesWelcomeHeaderDisplay(), "The welcome header is not displayed");
        Assert.assertEquals(homePage.getTitle(), "Get started with Goodreads", "The title doesn't displays properly");

        LogHelper.info("Step: Searching for a book");
        homePage.searchABook(bookDescription);

        LogHelper.info("Step: Verify that a book display on search result page");
        Assert.assertEquals(searchResultPage.getBookDescription(), bookDescription, "The book item doesn't display");

        LogHelper.info("Step: Marking the book as 'Want to Read'");
        searchResultPage.clickWantToRead();

        LogHelper.info("Step: Verify that book is marked to read");
        Assert.assertTrue(searchResultPage.doesBookMarkedWantToRead(), "The book item doesn't mark to read");
    }
}
