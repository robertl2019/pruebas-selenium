
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class loginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public loginPage enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public loginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public loginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}

