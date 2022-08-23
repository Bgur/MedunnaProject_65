package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US015page {

    public US015page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement items_titles;

    @FindBy(xpath = "(//a[@href='/patient'])[1]")
    public WebElement Patient;

    @FindBy(id = "jh-create-entity")
    public WebElement createAnewPatientButton;

    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement patientFirstName;
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement patientLastName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement patientEmail;
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement patientPhoneNumber;
    @FindBy(xpath = "//input[@name='adress']")
    public WebElement patientAdress;
    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement patientBirthDay;
    @FindBy(xpath = "//select[@name='gender']")
    public WebElement patientGender;
    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement patientBloodGroup;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionTextBox;
    @FindBy(xpath = "//select[@name='user.id']")
    public WebElement patientUser;
    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement patientCountry;
    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement patientState;
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButonu;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement patientKayitOlusturuldu;



    }

