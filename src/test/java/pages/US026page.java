package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class US026page {

    public US026page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//*[text()='CONTACT']")
    public WebElement contactButton;

    @FindBy(xpath="//input[@placeholder='Name']")
    public
    WebElement nameYeri;

    @FindBy(xpath="//input[@placeholder='Email']")
    public
    WebElement emailYeri;

    @FindBy(xpath="//input[@placeholder='Subject']")
    public
    WebElement subjectYeri;

    @FindBy(xpath="//textarea[@placeholder='Message']")
    public
    WebElement messageYeri;

    @FindBy(xpath="//*[text()='Send']")
    public
    WebElement sendButton;

    @FindBy(xpath = "//*[text()='Your message has been received']")
    public
    WebElement mesajGonderildiYazisi;








}
