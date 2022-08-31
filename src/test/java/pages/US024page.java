package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US024page {
    public US024page(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "//a[@id='login-item']/span")
    public WebElement firstSingIn;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']/span")
    public WebElement secondSignIn;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/a/span")
    public WebElement myPages;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[1]/span")
    public WebElement myAppointments;

    @FindBy(xpath = "//*[text()='Show Tests']")
    public WebElement showTestButton;

    @FindBy(xpath = "//*[text()='View Results']")
    public  WebElement viewResultButton;

    @FindBy(xpath = "//*[text()='Test Results']")
    public WebElement testResults;

    @FindBy(xpath = "//*[text()='ID']")
    public WebElement idColumn;

    @FindBy(xpath = "//*[text()='Name']")
    public WebElement nameColumn;

    @FindBy(xpath = "//*[text()='Default Min. Value']")
    public WebElement minValueColumn;

    @FindBy(xpath = "//*[text()='Default Max. Value']")
    public WebElement maxValueColumn;

    @FindBy(xpath = "//*[text()='Description']")
    public WebElement descriptionColumn;

    @FindBy(xpath = "//*[text()='Show Invoice']")
    public WebElement showInvoiceButton;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/table/thead/tr[3]/th[2]")
    public WebElement faturaTarihi;



}
