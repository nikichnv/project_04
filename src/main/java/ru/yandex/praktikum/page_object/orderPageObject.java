package ru.yandex.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orderPageObject {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");  //локатор для поля Имя
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']"); // локатор для поля Фамилия
    private By adresField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // локатор для поля Адрес
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");     //локатор для поля Станция метро
    private By nomberPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // локатор для поля Телефон
    private By buttonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");// локатор для кнопки Далее

    public orderPageObject(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 3);
    }

    public void setNameField(String username) {
        driver.findElement(nameField).sendKeys(username);
    }

    public void setLastNameField(String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
    }

    public void setAdresField(String adres) {
        driver.findElement(adresField).sendKeys(adres);
    }

    public void setMetroField(String metro) {
        driver.findElement(metroField).sendKeys(metro, Keys.DOWN, Keys.ENTER);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void setNomberPhone(String phone) {
        driver.findElement(nomberPhone).sendKeys(phone);
    }


}