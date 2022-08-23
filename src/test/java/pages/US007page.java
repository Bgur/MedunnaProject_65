package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;

import utilities.Driver;
import utilities.JSUtils;

public class US007page {


    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//li[@class='dropdown nav-item']")
    public WebElement profileIcon;

    @FindBy (xpath = "//span[text()='Sign in']")
    public WebElement signInElementi;
    @FindBy (xpath = "//input[@name='username']")
    public WebElement usernameTextbox;
    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordTextbox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signInButtonu;

    @FindBy (xpath = "//a[@href='/logout']")
    public WebElement loginPageSignOutButton;

    @FindBy (xpath = "//span[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesButtonu;

    @FindBy (xpath = "//span[text()='Make an Appointment']")
    public WebElement loginPageMakeAnAppointmentButtonu;

    @FindBy (xpath = "//h2[text()='Make an Appointment']")
    public WebElement loginPageMakeAnAppointmentHeader;

    @FindBy (xpath = "//input[@name='phone']")
    public WebElement loginPagePhoneTextBox;

    @FindBy (xpath = "//div[text()='Phone number is invalid']")
    public WebElement loginPagePhoneErrorLine1;

    @FindBy (xpath = "//input[@name='appoDate']")
    public WebElement loginPageDateTextBox;

    @FindBy (xpath = "//span[text()='Send an Appointment Request']")
    public WebElement loginPageSendAnAppointmentRequestButton;

    @FindBy (xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement loginPageUserAccountButton;

    @FindBy (xpath = "(//div[@role='alert'])/span/strong")
    public WebElement alertText;
    // dynamic + static path ile alert textini alıyoruz

    @FindBy (xpath = "//span[text()='Appointment date can not be past date!']")
    public WebElement loginPageDateErrorLine;

    @FindBy (xpath = "//a[@class='appointment-btn scrollto']")
    public WebElement mainpageMakeAnAppointmentButtonu;

    @FindBy (xpath = "//span[text()='Send an Appointment Request']")
    public WebElement mainpageSendAnAppointmentRequestButton;

    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement mainpageFirstnameTextBox;

    @FindBy (xpath = "//input[@name='lastName']")
    public WebElement mainpageLastnameTextBox;

    @FindBy (xpath = "//input[@name='ssn']")
    public WebElement mainpageSSNTextBox;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement mainpageEmailTextBox;





    public void login(String roleUsername,String rolePassword)
    {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));

        JSUtils.clickElementByJS(profileIcon);
        JSUtils.clickElementByJS(signInElementi);
        // profileIcon.click();
        //signInElementi.click();
        // siteden kaynaklanan sıkıntılar nedeni ile click islemlerini selenium ile degil js ile yapiyoruz

        usernameTextbox.sendKeys(ConfigReader.getProperty(roleUsername));
        passwordTextbox.sendKeys(ConfigReader.getProperty(rolePassword));

        signInButtonu.click();
    }
    public void logout()
    {
        JSUtils.clickElementByJS(loginPageUserAccountButton);
        JSUtils.clickElementByJS(loginPageSignOutButton);

    }
}
