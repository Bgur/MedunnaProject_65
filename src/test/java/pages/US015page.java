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
    @FindBy(xpath = "//*[text()='SNN']")
    public WebElement patientSNN;
    @FindBy(xpath = "//*[text()='Created Date']")
    public WebElement patientCreatedDate;


    @FindBy(xpath = "//*[text()='856-45-6777']")
    public WebElement HastaSnnNumarasiKontrol;
    @FindBy(xpath = "//*[text()='Myrtice']")
    public WebElement HastaFirstNameKontrol;
    @FindBy(xpath = "//*[text()='Gaylord']")
    public WebElement HastaLastNameKontrol;
    @FindBy(xpath = "//*[text()='30/07/67 03:17']")
    public WebElement HastaBirthDateKontrol;
    @FindBy(xpath = "(//*[text()='4165667780'])[3]")
    public WebElement HastaPhoneNumberKontrol;
    @FindBy(xpath = "(//*[text()='FEMALE'])[1]")
    public WebElement HastaGenderKontrol;
    @FindBy(xpath = "(//*[text()='B-'])[2]")
    public WebElement HastaBloodGroupKontrol;
    @FindBy(xpath = "//*[text()='Antalya']")
    public WebElement HastaAdressKontrol;
    @FindBy(xpath = "//*[text()='asthma']")
    public WebElement HastaDescriptionKontrol;
    @FindBy(xpath = "//*[text()='28/12/21 10:24']")
    public WebElement HastaCreatedDateKontrol;
    @FindBy(xpath = "//*[text()='admin']")
    public WebElement HastaUserKontrol;
    @FindBy(xpath = "(//*[text()='Turkey'])[2]")
    public WebElement HastaCountryKontrol;
    @FindBy(xpath = "//*[text()='Van']")
    public WebElement HastaStateCityKontrol;
    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement ilkHastaEditButonu;
    @FindBy(xpath = "//span[text()='SNN']")
    public WebElement hastaSNN;
    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement hastaFirstName;
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement hastaLastName;
    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement hastaBirthDate;
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement hastaPhoneNumber;
    @FindBy(xpath = "//select[@name='gender']")
    public WebElement hastaGender;
    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement hastaBloodGroup;
    @FindBy(xpath = "//input[@name='adress']")
    public WebElement hastaAdress;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement hastaDescription;
    @FindBy(xpath = "//span[text()='Created Date']")
    public WebElement hastaCreatedDate;
    @FindBy(xpath = "//select[@name='user.id']")
    public WebElement hastaUser;
    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement hastaCountry;
    @FindBy(xpath = "//*[text()='Save']")
    public WebElement guncellemeSaveButonu;
    @FindBy(xpath = "(//*[text()='Appointment'])[1]")
    public WebElement appointmentButonu;
    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement doktorAtamaEditButonu;
    @FindBy(xpath = "//select[@name='physician.id']")
    public WebElement doktorSecme;
    @FindBy(xpath = "//*[text='The Appointment is updated with identifier 2301']")
    public WebElement hastayaDoktorAtandiYazisi;




    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement hastaStateCity;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement hastaBilgisiGuncellendi;









    }

