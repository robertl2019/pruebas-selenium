import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class LoginSteps {
    private WebDriver driver;
    private loginPage loginPage;
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Configura el controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new loginPage(driver);

        // Abre la página de inicio de sesión
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter the username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username).enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        // Agregar verificaciones adicionales después del inicio de sesión exitoso
        // Por ejemplo, verificar que se haya redirigido a la página de productos
        assertTrue(driver.getCurrentUrl().contains("/inventory.html"));
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        // Verifica que se muestre el mensaje de error esperado
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("I should still be on the login page")
    public void iShouldStillBeOnTheLoginPage() {
        // Verifica que aún estemos en la página de inicio de sesión
        assertTrue(driver.getCurrentUrl().contains("/index.html"));
    }
}