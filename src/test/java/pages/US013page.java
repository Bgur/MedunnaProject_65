package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US013page {

    public US013page() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement singInButtonu;

    @FindBy(xpath = "(//input[@name='username'])[1]")
    public WebElement userName;

    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement password;

    @FindBy(xpath = "(//*[text()='Sign in'])[3]")
    public WebElement girisSonrasiSingIn;

    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesButton;

    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement myAppointmentsButton;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButtonu;

    @FindBy(xpath = "//*[text()='Request A Test']")
    public WebElement requestATestButonu;

    @FindBy(xpath = "//tr//td[2]") // hangi sutunda oldugunu buldum
    public List<WebElement> testIsimListesi;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> testSecmeButonuListesi;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement saveButonu;

    @FindBy(xpath = "//*[text()='Show Test Results']")
    public WebElement showTestResultsButonu;

    @FindBy(xpath = "//*[text()='View Results']")
    public WebElement viewResultsButonu;

    @FindBy(xpath = "//*[text()='ID']")
    public WebElement idGorunurluk;

    @FindBy(xpath = "//*[text()='Name']")
    public WebElement nameGorunurluk;

    @FindBy(xpath = "//*[text()='Default Min. Value']")
    public WebElement defaultMinValueGorunurluk;

    @FindBy(xpath = "//*[text()='Default Max. Value']")
    public WebElement defaultMaxValueGorunurluk;

    @FindBy(xpath = "//*[text()='Test']")
    public WebElement testGorunurluk;

    @FindBy(xpath = "//*[text()='Description']")
    public WebElement descriptionGorunurluk;

    @FindBy(xpath = "//*[text()='Date']")
    public WebElement dateGorunurluk;

    @FindBy(xpath = "//*[text()='Request Inpatient']")
    public WebElement requestInPatientButonu;









}
