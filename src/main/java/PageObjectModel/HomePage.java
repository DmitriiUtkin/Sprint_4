package PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final String HOME_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    //логотип-ссылка Яндекс:
    private By logoYandex = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");

    //логотип-ссылка Самокат:
    private By logoSamokat = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");

    //кнопка "Статус заказа":
    private By buttonOrderStatus = By.xpath(".//button[@class='Header_Link__1TAG7']");

    //кнопка "Go!":
    private By buttonGo = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    //поле с плейсхолдером "Введите номер заказа":
    private By fieldFillInOrderNumber = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");

    //кнопка "Да все привыкли":
    private By buttonCookies = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //кнопки "Заказать"
    private static final By ORDER_BUTTONS = By.xpath(".//button[contains(text(), 'Заказать')]");

    public void clickOrderButtonMainPage () {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ORDER_BUTTONS));
        driver.findElement(ORDER_BUTTONS).click();
    }

    //    верхняя кнопка "Заказать":
    private static final By BUTTON_ORDER_UP = By.xpath(".//button[@class='Button_Button__ra12g']");

    public void clickButtonOrderUp() {
        driver.findElement(BUTTON_ORDER_UP).click();

    }

    //нижняя кнопка "Заказать":
    private By buttonOrderDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //нижняя кнопка "Заказать":
//    private static final By orderButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //вопросы:
    private By questions = (By.xpath(".//div[contains(@id, 'accordion__heading')]"));

    //ответы:
    private By answers = (By.xpath(".//div[contains(@class, 'accordion__panel')]"));

    public List<WebElement> getQuestions() {
        return driver.findElements(questions);
    }

    public List<WebElement> getAnswers() {
        return driver.findElements(answers);
    }

    public String getAnswerTextByIndex(int index) {
        return driver.findElements(answers).get(index).getText();
    }

    public void clickQuestionByIndex(int index) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElements(questions).get(index));
        String questionText = driver.findElements(questions).get(index).getText();
        driver.findElements(questions).get(index).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String answerText = driver.findElements(answers).get(index).getText();
    }

}










