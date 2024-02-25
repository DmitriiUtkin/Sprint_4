import PageObjectModel.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderButtonTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private static final By BUTTON_ORDER_UP = By.xpath(".//button[@class='Button_Button__ra12g']");

    private static final By BUTTON_ORDER_DOWN = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By NAME = By.xpath(".//input[@placeholder='* Имя']");
    private static final int TIME_OUT_IN_SECONDS = 3;


    @Before
    public void setUp() {
        driver = SelectingBrowser.createDriver("chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        driver.get(PAGE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void clickButtonOrderUp() {
        driver.findElement(BUTTON_ORDER_UP).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME));
        Assert.assertTrue(driver.findElement(NAME).isDisplayed());
        driver.navigate().refresh();
    }

    @Test
    public void clickButtonOrderDown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(BUTTON_ORDER_DOWN));
        driver.findElement(BUTTON_ORDER_DOWN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME));
        Assert.assertTrue(driver.findElement(NAME).isDisplayed());
    }
}

