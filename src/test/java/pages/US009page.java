package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class US009page {

    public US009page(){
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

    @FindBy(xpath = "/html/body/div/div/div/div[2]/nav/div/ul/li[7]/a/span")
    public WebElement MyPages;

    @FindBy(xpath = "//a[@class='dropdown-item']/span")
    public WebElement searchPatient;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement patientSsnSearchBox;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]")
    public WebElement patientID;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[2]/span")
    public WebElement edit;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameS;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[2]")
    public WebElement kontrolSSN;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[3]")
    public WebElement kontrolFirstName;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[4]")
    public WebElement kontrolLastName;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[5]")
    public WebElement kontrolBirtDate;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[6]")
    public WebElement kontrolPhone;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[7]")
    public WebElement kontrolEmail;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[8]")
    public WebElement kontrolGender;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[9]")
    public WebElement kontrolBloodGroup;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[10]")
    public WebElement kontrolAddress;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[11]")
    public WebElement kontrolDescription;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[13]")
    public WebElement kontrolUser;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[14]")
    public WebElement kontrolCountry;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birtDate;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//select[@name='gender']")
    public WebElement gender;

    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement bloodGroup;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement adress;

    @FindBy(xpath = "//textarea[@id='patient-description']")
    public WebElement description;

    @FindBy(xpath = "//select[@name='user.id']")
    public WebElement user;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement country;

    @FindBy(xpath = "//button[@id='save-entity']/span")
    public WebElement saveButtonS;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/h2/b")
    public WebElement parientIdAfterSave;

// ###########  Admin  ###########

    @FindBy(xpath = "//li[@id='entity-menu']/a/span")
    public WebElement itemsTitles;

    @FindBy(xpath = "//li[@id='entity-menu']/div/a[1]")
    public WebElement patientButton;

    @FindBy(xpath = "(//td[@class='text-right']/div/a/span/span)[1]")
    public WebElement viewButton;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/dl/dd[1]")
    public WebElement patientSsn;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/dl/dd[2]")
    public WebElement patientFNameA;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/dl/dd[3]")
    public WebElement patientLNameA;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/dl/dd[5]")
    public WebElement patientPhoneA;

    @FindBy(xpath = "(//td[@class='text-right']/div/a/span/span)[2]")
    public WebElement editButton;

    @FindBy(xpath = "(//td[@class='text-right']/div/a/span/span)[3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"jhi-confirm-delete-patient\"]/span")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[1]")
    public WebElement internalServerError;

    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement patientFirstNameA;

    @FindBy(xpath = "//input[@id='patient-lastName']")
    public WebElement patientLastNameA;

    @FindBy(xpath = "//button[@id='save-entity']/span")
    public WebElement saveButtonA;






















}
