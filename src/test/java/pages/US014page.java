package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US014page {
    public US014page(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath ="//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement kullaniciIkonuElementi;

    @FindBy (xpath = "//a[@class='dropdown-item']")
    public  WebElement signInElementi;

    @FindBy (xpath = "//input[@name='username']")
    public WebElement kullaniciAdiGirisiElementi;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement sifreGirisiElementi;

    @FindBy (xpath = "(//*[text()='Sign in'])[3]")
    public WebElement ikinciSignInElementi;

    @FindBy (xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesElementi;

    @FindBy (xpath = "//*[text()='My Inpatients']")
    public WebElement myInPatientsElementi;

    @FindBy (xpath = "//*[text()='ID']")
    public WebElement idBaslikElementi;

    @FindBy (xpath = "//*[text()='Start Date']")
    public WebElement startDateBaslikElementi;

    @FindBy (xpath = "//*[text()='End Date']")
    public WebElement endDateBaslikElementi;

    @FindBy (xpath = "//*[text()='Status']")
    public WebElement statusBaslikElementi;

    @FindBy (xpath = "//*[text()='Description']")
    public WebElement descriptionBaslikElementi;

    @FindBy (xpath = "//*[text()='Created Date']")
    public WebElement createdDateBaslikElementi;

    @FindBy (xpath = "//*[text()='Room']")
    public WebElement roomBaslikElementi;

    @FindBy (xpath = "//*[text()='Appointment']")
    public WebElement appointmentBaslikElementi;

    @FindBy (xpath = "//*[text()='Patient']")
    public WebElement patientBaslikElementi;


    @FindBy (xpath = "(//*[text()='Edit'])[5]")
    public WebElement editElementi;

    @FindBy (xpath = "//select[@id='in-patient-status']")
    public WebElement statusDropDownElementi;

    @FindBy (xpath = "//option[@value='UNAPPROVED']")
    public WebElement dropDownUnapprovedElementi;

    @FindBy (xpath = "//input[@name='description']")
    public WebElement inpatientDescriptionElementi;

    @FindBy (xpath = "//select[@name='appointment.id']")
    public  WebElement inpatientAppointmentElementi;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public  WebElement inpatientSaveButtonElementi;

    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement inpatientAlertUpdatedElementi;

    @FindBy (xpath = "//select[@name='room.id']")
    public WebElement roomDropDownElementi;

    @FindBy (xpath = "//*[text()='The room already reserved']")
    public WebElement roomReservedAlertElementi;
}

