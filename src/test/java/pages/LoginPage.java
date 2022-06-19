package pages;

import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {

    private final By lnkSignIn = By.id("com.goodreads:id/sign_in_button");
    private final By txtEmail = By.id("com.goodreads:id/email");
    private final By txtPassword = By.id("com.goodreads:id/password");
    private final By btnLogin = By.id("com.goodreads:id/login_button");

    public void clickSignInLink() {
        waitForElementToBeClickable(lnkSignIn);
        click(lnkSignIn);
    }

    public void login(String userName, String password) {
        clickSignInLink();
        waitForElementVisibility(txtEmail);
        enter(txtEmail, userName);
        enter(txtPassword, password);
        waitForElementToBeClickable(btnLogin);
        click(btnLogin);
    }
}
