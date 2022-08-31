package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US019page {
    public US019page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement signInLocation;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "(//*[text()='Sign in'])[3]")
    public WebElement signInButtonForUsers;

    @FindBy(xpath = "//*[text()='Items&Titles']")
    public WebElement itemsAndTitles;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[2]/span")
    public WebElement staffInDropDownMenu;

    @FindBy(xpath = "//*[text()='Create a new Staff']")
    public WebElement createANewStaffButton;

    @FindBy(xpath = "//*[@id=\"useSSNSearch\"]")
    public WebElement getUseSSNSearchCheckBox;

    @FindBy(xpath = "//input[@id='searchSSN']")
    public WebElement getSearchSSNTextBox;

    @FindBy(xpath = "//*[text()='Search User']")
    public WebElement getSearchUserButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[3]/td[15]/div/a[2]/span/span")
    public WebElement userWhoWillBeUpdated;

    @FindBy(xpath = "//*[@id=\"emirha\"]/td[11]/div/a[3]/span/span")
    public WebElement userWhoWillBeDeleted;

    @FindBy(xpath = "document.querySelector(\"body > div:nth-child(13) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-danger > span\")")
    public WebElement getDeleteConfirmationButtonByJS;

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement signedInUserName;

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administrationIcon;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement goToUserManagement;

    @FindBy(xpath = "//*[text()='Create a new user']")
    public WebElement createANewUser;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginTextBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnTextBox;

    @FindBy(xpath = "//select[@id='authorities']")
    public WebElement roleDdm;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "(//*[text()='Medunna'])[1]")
    public WebElement medunnaText;

    @FindBy(xpath = "//*[text()='Search User']")
    public WebElement searchUser;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDate;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement adressTextBox;

    @FindBy(xpath = "//select[@id='physician-gender']")
    public WebElement genderTextBox;

    @FindBy(xpath = "//select[@id='physician-speciality']")
    public WebElement specialityDdm;

    @FindBy(xpath = "//select[@id='physician-bloodGroup']")
    public WebElement bloodGroupTextBox;

    @FindBy(xpath = "//input[@id='physician-description']")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//select[@id='staff-user']")
    public WebElement userFieldTextBox;

    @FindBy(xpath = "//input[@id='physician-examFee']")
    public WebElement examFee;

    @FindBy(xpath = "//select[@id='physician-country']")
    public WebElement countryTextBox;

}
