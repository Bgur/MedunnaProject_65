package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US028page {

    public US028page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement humanButton;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement SingInMenuButton;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement SingInUserNameKutusu;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement SingInPasswordKutusu;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement SingInSingInButton;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-th-list fa-w-16 ']")
    public WebElement itemsTitlesButonu;

    @FindBy(xpath = "//a[@href='/country']")
    public WebElement countryButonu;

    @FindBy(xpath = "//*[text()='Create a new Country']")
    public WebElement createCountryButonu;

    @FindBy(xpath = "//input[@id='country-name']")
    public WebElement createCountryNameButonu;

    @FindBy(xpath = "//*[@name='createdDate']")
    public WebElement tarihSaatButonu;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButonu;

    @FindBy(xpath = "//*[text()='State/City']")
    public WebElement stateCityButonu;

    @FindBy(xpath = "//*[text()='Create a new State/City']")
    public WebElement createStateCityButonu;

    @FindBy(xpath = "//*[@id='c-state-state']")
    public WebElement stateCitySecmeButonu;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement kirmiziUyariYazisi;

    @FindBy(xpath = "//*[@id='c-state-name']")
    public WebElement createStateCityNameButonu;

    @FindBy(xpath = "//*[text()='Delete']")
    public WebElement deleteButonu;

    @FindBy(xpath = "//tr//td[2]")
    public List<WebElement> tumUlkeIsimleri;

    @FindBy(xpath = "//*[@class='modal-content']")
    public WebElement deleteOperationYazisi;

    @FindBy(xpath = "//*[@id='jhi-confirm-delete-country']")
    public WebElement ikiciDeleteButonu;














}
