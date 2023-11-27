package ru.yandex.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class secondOrderPageObject {

    private WebDriver driver;
    //локатор для описания для курьера
    private final By descriptionForMan = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор для даты привоза
    private final By calendar = By.xpath(".//div[@class='react-datepicker__input-container']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //локатор для даты 20
    private final By day20 = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--020']");
    // локатор для срока аренды
    private final By arendaField = By.xpath(".//div[@class='Dropdown-placeholder']");
    // локатор для выбора 2 суток в поле аренды
    private final By twoDays = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    // локатор для цвета черный
    private final By blackCheckbox = By.xpath(".//input[@id='black']");
    // локатор для заказать
    private final By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // локатор кнопки ДА
    private final By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //локатор для окна подтверждения
    private final By modalWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    //локатор для окна оформления заказа
    private final By orderMessage = By.xpath(".//*[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public secondOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setDescriptionForMan(String description) {
        driver.findElement(descriptionForMan).sendKeys(description);
    }

    public void clickCalendar() {
        driver.findElement(calendar).click();
    }

    public void choiceDay() {
        driver.findElement(day20).click();
    }

    public void clickArendaField() {
        driver.findElement(arendaField).click();
    }

    public void choiceDayArend() {
        driver.findElement(twoDays).click();
    }

    public void clickBlackChevkbox() {
        driver.findElement(blackCheckbox).click();
    }

    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    public void clickButtonYes() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(modalWindow));
        driver.findElement(buttonYes).click();
    }

    public String getOrderMessage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(orderMessage));
        WebElement orderText = driver.findElement(orderMessage);
        return orderText.getText();
    }
}