package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US010page {

    public US010page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement KullaniciIkonu;

    @FindBy (xpath = "//*[@id='login-item']")
    public WebElement singIn;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement singInUsernameTextBox;



    @FindBy (xpath = "//*[@type='submit']")
    public WebElement  singInButonu;

    @FindBy (xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesButonu;

    @FindBy (xpath = "//*[text()='My Appointments']")
    public WebElement myAppointmentsButonu;

    @FindBy (xpath = "//*[text()='Appointments']")
    public WebElement apppointmentsPagesText;


    @FindBy (xpath = "//tbody//tr//td[1]")
    public WebElement randevuID;

    @FindBy (xpath = "//tbody//tr//td[2]")
    public WebElement startDateTime;

    @FindBy (xpath = "//tbody//tr//td[3]")
    public WebElement endDateTime;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public WebElement status;


}


