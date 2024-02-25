import PageObjectModel.HomePage;
import PageObjectModel.OrderFormPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = SelectingBrowser.createDriver("chrome");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidUser1_pom1() {
        HomePage homePage = new HomePage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        orderFormPage.open();
        homePage.clickOrderButtonMainPage();
        orderFormPage.fillInFormForWhomScooter("Василий", "Петров", "Москва, ул. Пушкина, 1", "Бульвар Рокоссовского", "+79181234567");
        orderFormPage.fillInFormAboutRent(1, "04.03.2024");
        orderFormPage.clickYesInPopUpWindow();
        orderFormPage.checkingConfirmationMessageIsDisplayed();
    }

    @Test
    public void testValidUser2_pom2() {
        HomePage homePage = new HomePage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        orderFormPage.open();
        homePage.clickOrderButtonMainPage();
        orderFormPage.fillInFormForWhomScooter("Мария", "Сидорова", "Москва, ул. Гоголя, 5", "Черкизовская", "+79001234567");
        orderFormPage.fillInFormAboutRent(2, "08.03.2024");
        orderFormPage.clickYesInPopUpWindow();
        orderFormPage.checkingConfirmationMessageIsDisplayed();
    }
}



