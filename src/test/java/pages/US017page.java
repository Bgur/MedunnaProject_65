package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US017page {
    public US017page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement userIsareti;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInIsareti;

   @FindBy(xpath = "//input[@placeholder='Your username']")
    public WebElement userNameTextBox;

   @FindBy(xpath = "//input[@placeholder='Your password']")
    public WebElement passwordTextBox;

   @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmit;

   @FindBy(xpath = "(//*[@class='dropdown nav-item'])[3]]")
    public WebElement itemsButton;

   @FindBy(xpath = "(//*[text()='Test Item'])[2]")
    public WebElement testItemButton;

   @FindBy(xpath = "//*[text()='Create a new Test Item']")
    public WebElement createTestItemButton;

   @FindBy(xpath = "(//*[@*='c-test-item-name'])[2]")
    public WebElement nameKutusu;

   @FindBy(xpath = "(//*[@*='c-test-item-description'])[2]")
    public WebElement descriptionKutusu;

   @FindBy(xpath = "(//*[@*='c-test-item-price'])[2]")
    public WebElement priceKutusu;

   @FindBy(xpath = "(//*[@*='c-test-item-defaultValMin'])[2]")
    public WebElement minValKutusu;

   @FindBy(xpath = "(//*[@*='c-test-item-defaultValMax'])[2]")
    public WebElement maxValKutusu;

   @FindBy(xpath = "//*[@*='save-entity']")
    public WebElement saveKutusu;

   @FindBy(xpath = "(//*[@*='btn btn-link btn-sm'])[1]")
    public WebElement olusturulduID;

   @FindBy(xpath = "//*[text()='ID']")
    public WebElement idELementi;

   @FindBy(xpath = "(//*[@*='c-test-item-createdDate'])[2]")
    public WebElement createdDateELementi;

   @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement editElementi;

   @FindBy(xpath = "(//*[text()='View'])[1]")
    public WebElement viewElementi;

   @FindBy(xpath = "(//*[text()='Test Item'])[2]")
    public WebElement testItemElementi;

   @FindBy(xpath = "(//*[text()='Delete'])[1]")
    public WebElement deleteItemElementi;

   @FindBy(xpath = "(//*[text()='Delete'])[21]")
    public WebElement deleteDogrulaElementi;









}
