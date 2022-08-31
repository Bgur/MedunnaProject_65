package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US020page {
    Faker faker=new Faker();
    public US020page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //@FindBy notasyonu ile locatelerı buraya koyacagız.

    @FindBy (xpath ="//*[text()='Administration']")
    public WebElement administrationButonu;

    @FindBy (xpath ="//*[text()='User management']")
    public WebElement userManagementButonu;

    @FindBy (xpath = "//*[text()='Users']")
    public WebElement usersPageText;

    @FindBy (xpath = "(//span[@class='d-none d-md-inline'])[1]")
    public WebElement viewButonu;

    @FindBy (xpath = "//*[text()='First name']")
    public  WebElement firstnameText;

    @FindBy (xpath = "//*[text()='Last name']")
    public  WebElement lastnameText;

    @FindBy (xpath = "//*[text()='Email']")
    public  WebElement emailText;

    @FindBy (xpath = "//*[text()='Profiles']")
    public  WebElement profilesText;

    @FindBy (xpath = "//*[text()='Team 65']")
    public WebElement Team65Butonu;


    @FindBy (xpath = "//*[text()='Sign out']")
    public WebElement signOutButonu;

    @FindBy (xpath = "(//*[text()='Edit'])[1]")
    public WebElement editButonu;

    @FindBy (xpath = "//*[text()='Create or edit a user']")
    public WebElement createEditUserPagesText;

    @FindBy (xpath = "//*[text()='ROLE_ADMIN']")
    public WebElement roleAdmin;

    @FindBy (xpath = "//*[text()='ROLE_USER']")
    public WebElement roleUser;

    @FindBy (xpath = "//*[text()='ROLE_PATIENT']")
    public WebElement rolePatient;

    @FindBy (xpath = "//*[text()='ROLE_STAFF']")
    public WebElement roleStaff;

    @FindBy (xpath = "//*[text()='ROLE_PHYSICIAN']")
    public WebElement rolePhysician;

    @FindBy (xpath = "//*[text()='Save']")
    public WebElement savebutonu;

    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement editToastContainerText;

    @FindBy (xpath = "(//*[text()='Delete'])[4]")
    public WebElement deleteButonu;

    @FindBy (xpath = "//*[@class='modal-body']")
    public WebElement deletePopupText;

    @FindBy (xpath = "//button[@type='button']//span[contains(text(),'Delete')]")
    public WebElement deletePopupDeleteButonu;

    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteToastContainerText;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement signInsignInButonu;


    @FindBy (xpath = "//*[@id='password']")
    public WebElement signInPasswordTextBox;
    @FindBy (xpath = "//*[@id='username']")
    public WebElement signInUsernameTextBox;

    @FindBy (xpath = "//*[text()='Sign in']")
    public WebElement signInButonu;

    @FindBy (xpath = "//*[@id='account-menu']")
    public WebElement profilIkonuButonu;


   @FindBy (xpath = "//input[@id='activated']")
    public WebElement activatedKutucugu;




}
