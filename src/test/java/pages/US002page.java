package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US002page {
    public US002page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Faker faker = new Faker();


    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameTextBox;
    public US002page userNameTextBox() {
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        userNameTextBox.click();
        return this;
    }
    public US002page GecerliUserName() throws InterruptedException {
        Thread.sleep(3000);
        String    username= faker.name().username();
        userNameTextBox.sendKeys(username);
        return this;
    }

    public US002page GecersizUserName(String karakter)  {
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.waitFor(2);
        userNameTextBox.sendKeys(karakter+ Keys.TAB);
        Assert.assertTrue(userNameValidConfirm.isDisplayed());

        ReusableMethods.waitFor(2);

        return this;
    }
    public US002page GecersizOUserName(String ozelKarakter)  {
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.waitFor(2);
        userNameTextBox.sendKeys(ozelKarakter+ Keys.TAB);
        Assert.assertTrue(usernameInvalidMessage.isDisplayed());

        ReusableMethods.waitFor(2);

        return this;
    }
    public US002page GecerliUserName(String username)  {
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.waitFor(2);
        userNameTextBox.sendKeys(username+ Keys.TAB);
        Assert.assertTrue(userNameValidConfirm.isDisplayed());

        ReusableMethods.waitFor(2);

        return this;
    }



    @FindBy(xpath = "//div[text()='Your username is required.']")
    public WebElement userNameRequiredMessage;
    public US002page userNameRequiredMessage() {

        assertTrue(userNameRequiredMessage.isDisplayed());
        return this;
    }

    @FindBy(xpath = "//div[text()='Your username is invalid.']")
    public WebElement usernameInvalidMessage;
    public US002page usernameInvalidMessage() {
        assertTrue(usernameInvalidMessage.isDisplayed());
        return this;
    }

    @FindBy(xpath = "//input[@class='is-touched is-dirty av-valid form-control']")
    public WebElement userNameValidConfirm;
    public US002page userNameValidConfirm() {
        assertTrue(userNameValidConfirm.isDisplayed());
        return this;
    }



    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTextBox;
    public US002page emailTextBox() {
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        emailTextBox.click();
        return this;
    }
    public US002page GecerliEmail(String email)  {

        emailTextBox.sendKeys(email);
        return this;
    }
    public US002page GecersizEmail(String mail)  {


        emailTextBox.sendKeys(mail);
        return this;
        ///oooooo
    }

    @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement emailRequiredMessage;
    public US002page  emailRequiredMessage() {
        assertTrue( emailRequiredMessage.isDisplayed());
        return this;
    }

    @FindBy(xpath = "//div[text()='Your email is required to be at least 5 characters.']")
    public WebElement emailCharacterMessage;
    public US002page  emailCharacterMessage() {
        assertTrue( emailCharacterMessage.isDisplayed());
        return this;
    }

    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement emailInvalidMessage;
    public US002page  emailInvalidMessage() {
        assertTrue( emailInvalidMessage.isDisplayed());
        return this;
    }

    @FindBy(xpath = "//input[@class='is-touched is-dirty av-valid form-control']")
    public WebElement emailValidConfirm;
    public US002page  emailValidConfirm() {
        assertTrue( emailValidConfirm.isDisplayed());
        return this;
    }
}
