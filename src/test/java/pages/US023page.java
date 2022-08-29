package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US023page {

    public US023page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement MyPages;

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement SignInIcon;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement SignInDropDownLink;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement UsernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement PasswordBox;

    @FindBy(xpath = "(//span[text()='Sign in'])[3]")
    public WebElement SigninEnterTusu;

    @FindBy(xpath = "//span[text()='MY PAGES(PATIENT)']")
    public WebElement MyPagesPatientButton;

    @FindBy(xpath = "//span[text()='View Results']")
    public WebElement ViewResultsButton;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement MyAppointmentsDropDownItem;

    @FindBy(xpath = "//span[text()='Show Invoice']")
    public WebElement ShowInvoiceBox;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement SearchPatient;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement SearchPatientSSNBox;

    @FindBy(xpath = "//span[text()='Show Appointments']")
    public WebElement ShowAppointmentsButton;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement PaymentInvoiceProcessButton;

    @FindBy(xpath = "//th[text()='PAYMENT DETAIL']")
    public WebElement PaymentDetailPageText;

    @FindBy(xpath = "//span[text()='COMPLETED']")
    public WebElement RandevuDurumu;

    @FindBy(xpath = "//th[text()='450']")
    public WebElement ExamFee;

    @FindBy(xpath = "//td[@style='font-size: 15px;'][2]")
    public WebElement TestItemFee;

    @FindBy(xpath = "(//a[text()=' Show Invoice'])[1]")
    public WebElement ShowInvoiceButton;

    @FindBy(xpath = "//th[text()='INVOICE']")
    public WebElement InvoicePageTitleText;

    @FindBy(xpath = "(//a[text()=' Create Invoice'])[1]")
    public WebElement CreateInvoiceButton;

    @FindBy(xpath = "//input[@id='bill-id']")
    public WebElement BillIdKutusu;

    @FindBy(xpath = "//input[@name='date']")
    public WebElement BillDateKutusu;

    @FindBy(xpath = "//input[@name='billName']")
    public WebElement BillNameKutusu;

    @FindBy(xpath = "//input[@name='paymentMethod']")
    public WebElement BillPaymentKutusu;

    @FindBy(xpath = "//input[@ID='bill-description']")
    public WebElement BILLDescriptionKutusu;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement EditaBillSavebutonu;

    @FindBy(xpath = "(//span[text()='Sign in'])[3]")
    public WebElement HastaSignInbutonu;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement ShowTestsbutonu;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline']")
    public WebElement TestResultsbutonu;

    @FindBy(xpath = "(//th[@class='hand'])[1]")
    public WebElement TestResultsId;

    @FindBy(xpath = "(//th[@class='hand'])[2]")
    public WebElement TestResultsName;

    @FindBy(xpath = "(//th[@class='hand'])[3]")
    public WebElement TestResultsResult;

    @FindBy(xpath = "(//th[@class='hand'])[4]")
    public WebElement TestResultsDefaultMinValue;

    @FindBy(xpath = "(//th[@class='hand'])[5]")
    public WebElement TestResultsDefaultMaxValue;

    @FindBy(xpath = "(//span[text()='Test']")
    public WebElement TestResultsTest;

    @FindBy(xpath = "(//th[@class='hand'])[6]")
    public WebElement TestResultsDescription;

    @FindBy(xpath = "(//th[@class='hand'])[7]")
    public WebElement TestResultsDate;

    @FindBy(xpath = "(//a[@class='btn btn-warning btn-sm'])[1]")
    public WebElement AppointmentsShowInvoiceButton;

    @FindBy(xpath = "//th[text()='INVOICE']")
    public WebElement AppointmentsInvoiceTitleText;
}
