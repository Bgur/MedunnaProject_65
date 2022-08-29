package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US027page {
    public US027page(){
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

    @FindBy (xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement itemsAndTitlesElementi27;

    @FindBy (xpath = "(//*[text()='Messages'])[1]")
    public WebElement messagesDropDownElementi;

    @FindBy (xpath = "//*[text()='ID']")
    public WebElement messagesIdElementi;

    @FindBy (xpath = "//*[text()='Name']")
    public WebElement messagesNameElementi;

    @FindBy (xpath = "//*[text()='Email']")
    public WebElement messagesEmailElementi;

    @FindBy (xpath = "//*[text()='Subject']")
    public WebElement messagesSubjectElementi;

    @FindBy (xpath = "//*[text()='Message']")
    public WebElement messagesMessageElementi;

    @FindBy (xpath = "//div[@class='copyright']")
    public WebElement copyrightElementi;

    @FindBy (xpath = "//*[text()='Create a new Message']")
    public WebElement createNewMessageElementi;

    @FindBy (xpath = "//input [@name='name']")
    public WebElement messageNameEntryElementi;

    @FindBy (xpath = "//input [@name='email']")
    public WebElement messageEmailEntryElementi;

    @FindBy (xpath = "//input [@name='subject']")
    public WebElement messageSubjectEntryElementi;

    @FindBy (xpath = "//input [@name='message']")
    public WebElement messageMessageEntryElementi;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement messageEntrySaveElementi;

    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement messageEntryAlertElementi;

    @FindBy (xpath = "//button[@id='jhi-confirm-delete-cMessage']")
    public WebElement messageDeletConfirmElementi;



}
