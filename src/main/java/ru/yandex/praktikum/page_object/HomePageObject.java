package ru.yandex.praktikum.page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {
    private final WebDriver driver;
    //локатор  для раскрытия вопросов
    private final By acordionHeader = By.xpath(".//div[contains(@id,'accordion__heading')]");
    // локатор для ответа
    private final By accordionItems = By.xpath((".//div[contains(@id,'accordion__panel')]/p"));
    //локатор кнопки Заказать в верхней части страницы
    private final By orderButtonUpOnHomePage = By.xpath(".//button[@class='Button_Button__ra12g']");
    //локатор кнопки Заказать в центре страницы
    private final By orderButtonMiddleHmePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //окно заказа
    private final By orderWindow = By.xpath(".//div[text()='Для кого самокат']");


    // кнопка куки
    private final By buttonCookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    private final String site = "https://qa-scooter.praktikum-services.ru/";

    public HomePageObject(WebDriver driver) {
        this.driver = driver;

    }

    public void open() {
        driver.get(site);
    }

    public void clickOrderButtonUpOnHomePage() {
        WebElement orderButtonElement = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(orderButtonUpOnHomePage));
        orderButtonElement.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(orderWindow));
    }

    public void clickOrderButtonMiddleHmePage() {
        WebElement orderButtonElement = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(orderButtonMiddleHmePage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderButtonElement);
        WebElement orderButtonElementClick = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(orderButtonMiddleHmePage));
        orderButtonElementClick.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(orderWindow));
    }

    public void openAcordionHeader(int index) {
        WebElement questionElement = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(acordionHeader));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        WebElement questionElementIndex = driver.findElements(acordionHeader).get(index);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(questionElementIndex));
        questionElementIndex.click();
    }

    public String getAcordionHeader(int index) {
        WebElement headerElement = driver.findElements(acordionHeader).get(index);
        return headerElement.getText();
    }

    public String getAccordionItems(int index) {
        WebElement itemElement = driver.findElements(accordionItems).get(index);
        return itemElement.getText();
    }


    public void clickButtonCookie() {
        WebElement cookie = driver.findElement(buttonCookie);
        if (cookie.isDisplayed()) {
            cookie.click();
        }
    }
}




