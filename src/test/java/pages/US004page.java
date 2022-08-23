package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class US004page {
    public US004page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement signInIcon;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signInLogin;


    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passWord;

    @FindBy(xpath = "//input[@name='rememberMe']")
    public WebElement rememberMe;

    @FindBy(xpath = "//*[text()='Did you forget your password?']")
    public WebElement forgetPasswordText;

    @FindBy(xpath = "//a[@href='/account/reset/request']")
    public WebElement getForgetPasswordLink;

    @FindBy(xpath = "//*[contains(text(),'have an account yet')]")
    public WebElement haveAnAccountYetText;

    @FindBy(xpath = "(//a[@href='/account/register'])[2]")
    public WebElement haveAnAccountYetLink;

    @FindBy(xpath = "//*[text()='Register a new account']")
    public WebElement newAccount;

    @FindBy(xpath = "//div//button//span[text()='Sign in']")
    public WebElement signInForm;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancel;

    @FindBy(xpath = "//strong[text()='Failed to sign in!']")
    public WebElement failedToSignIn;

    @FindBy(xpath = "//span[text()='baran Team66']")
    public WebElement hesapAdi;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement containerDidYouForget;


}
