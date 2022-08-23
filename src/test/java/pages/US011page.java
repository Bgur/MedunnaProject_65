package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US011page {

    public US011page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//a[text()='Make an appointment']")
    public WebElement makeAnAppointment;

    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement firstnameTextBox;

    @FindBy (xpath = "//input[@name='lastName']")
    public WebElement lastNameTextBox;

    @FindBy (xpath = "//input[@name='ssn']")
    public WebElement ssnTextBox;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@name='phone']")
    public WebElement phoneTextBox;


    @FindBy (xpath = "//*[@id='register-submit']")
    public WebElement sendAppointmentButonu;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement editButonu;

    @FindBy (xpath = "//div[@role='alert\']")
    public WebElement randevuGuncellendi;

    @FindBy (xpath = "//tbody//tr//td[1]")
    public WebElement id;

    @FindBy (xpath = "//tbody//tr//td[2]")
    public WebElement startDateTime;

    @FindBy (xpath = "//tbody//tr//td[3]")
    public WebElement endDateTime;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public WebElement status;

    @FindBy (xpath = "//tbody//tr//td[11]")
    public WebElement physician;

    @FindBy (xpath = "//tbody//tr//td[12]")
    public WebElement patient;

    @FindBy (xpath = "//*[text()='Appointment registration saved!']")
    public WebElement KayitOlusturulduYazisi;

    @FindBy (xpath = "//*[@id='save-entity']")
    public WebElement saveButonu;

    @FindBy (xpath = "//*[@name='status']")
    public WebElement statusDropDown;


    @FindBy(xpath = "//*[@id='appointment-anamnesis']")
    public WebElement anamnesisTextBox;

    @FindBy(xpath = "//*[@id='appointment-treatment']")
    public WebElement treatmentTextBox;

    @FindBy(xpath = "//*[@id='appointment-diagnosis']")
    public WebElement diagnosisTextBox;

    @FindBy(xpath = "//*[@id='appointment-prescription']")
    public WebElement prescriptionTextBox;

    @FindBy(xpath = "//*[@id='appointment-description']")
    public WebElement descriptionTextBox;





}



