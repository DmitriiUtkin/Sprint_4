import PageObjectModel.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class DropdownListParametrizedTest {
    private final String question;
    private final String answer;
    private WebDriver driver;

    private static final String HOME_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public DropdownListParametrizedTest (String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getText() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Before
    public void setUp() {
        driver = SelectingBrowser.createDriver("chrome");
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDropdownList() {
        HomePage homePage = new HomePage(driver);
        List<WebElement> questionsList = homePage.getQuestions();
        List<WebElement> answersList = homePage.getAnswers();

        for (int i = 0; i < questionsList.size(); i++) {
            if (questionsList.get(i).getText().equals(question)) {
                homePage.clickQuestionByIndex(i);
                String actualAnswer = homePage.getAnswerTextByIndex(i);
                assertEquals("Проверка ответа на вопрос: " + question, answer, actualAnswer);
                break;
            }
        }
    }
}