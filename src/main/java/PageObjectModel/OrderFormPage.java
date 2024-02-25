package PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By NAME = By.xpath(".//input[@placeholder='* Имя']");
    private static final By SURNAME = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By ADDRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By METRO_STATION = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By TELEPHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By NEXT_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By WHEN_BRING_SCOOTER = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By RENT_TIME = By.xpath(".//div[@class='Dropdown-placeholder']");
    private static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By YES_BUTTON = By.xpath(".//button[contains(text(),'Да')]");
    private static final By CONFIRMATION_IMAGE = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Заказ оформлен')]");

    private static final int TIME_OUT_IN_SECONDS = 3;
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";


    public void open() {
        driver.get(PAGE_URL);
    }

    public void fillInFormForWhomScooter(String name, String surname, String address, String metroStation, String telephone) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME));
        driver.findElement(NAME).sendKeys(name);
        driver.findElement(SURNAME).sendKeys(surname);
        driver.findElement(ADDRESS).sendKeys(address);
        driver.findElement(METRO_STATION).click();
        driver.findElement(By.xpath("//div[contains(@class, 'Order_Text__2broi') and text()='" + metroStation + "']")).click();
        driver.findElement(TELEPHONE).sendKeys(telephone);
        driver.findElement(NEXT_BUTTON).click();
//
    }

    public void fillInFormAboutRent(int days, String date) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(RENT_TIME));
        driver.findElement(RENT_TIME).click();
        driver.findElement(By.xpath("(//div[@class='Dropdown-option'])["+days+"]")).click();
        driver.findElement(WHEN_BRING_SCOOTER).sendKeys(date);
        driver.findElement(ORDER_BUTTON).click();
    }

    public void clickYesInPopUpWindow() {
        driver.findElement(YES_BUTTON).click();
    }

    public void checkingConfirmationMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        WebElement confirmationImage = wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_IMAGE));
        Assert.assertTrue(confirmationImage.isDisplayed());
    }

}

