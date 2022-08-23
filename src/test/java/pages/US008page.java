package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.ArrayList;
import java.util.List;

public class US008page {

    public US008page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //Medunna>MainPage/Ana sayfadaki Welcome To Medunna yazısı
    @FindBy(xpath = "//*[@id=\"hero\"]/div/h1")
    public WebElement anaSayfaWelcomeToMedunnaYazisi;
    //Medunna>MainPage/Ana sayfada sağ üstte ki kullanıcı ikonnu
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement anaSayfaKullaniciIkonu;
    //Medunna>MainPage>Kullanıcı ikonu>Register Linki

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButonu;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement homePageSignInLinki;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement homePageUsernameBox;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement homePagePasswordBox;

    @FindBy(xpath = "//span[contains(.,'Password')]")
    public WebElement kullaniciIkonuMenusuAltindakiPasswordYazisi;
    @FindBy(xpath = "//input[@name='currentPassword']")
    public WebElement passwordDegisikligiIcinGecerliPasswordBox;
    @FindBy(xpath = "//input[@name='newPassword']")
    public WebElement passwordDegisikligiIcinYeniPasswordbox;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement passwordDegisikligiIcinYeniPasswordConfirmBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement passwordDegisikligiIcinSaveButonu;
    @FindBy(xpath = "//*[@class='btn btn-success']")
    public WebElement homePageSignInButonu;
    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement passwordDegisikligiBasariliYazisi;

    @FindBy(xpath = "//*[@href='/logout']")
    public WebElement signOutLinki;
    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public WebElement passwordStrengthBirinciSeviye;
    @FindBy(xpath = "(//li[@style='background-color: rgb(221, 221, 221);'])[4]")
    public WebElement passwordStrengthBesinciSeviye;
    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement kullaniciIkoniGirisYaptiktanSonra;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signInLinkiElementi;
    //mainPage > SignIn/usernameBox


    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBoxElementi;


    public List<WebElement> testIDListOlusturma() {
        List<WebElement> testIDList = new ArrayList<WebElement>();

        for (int i = 1; i < 247; i++) {
            String xpath = "(//a[@class='btn btn-link btn-sm'])[" + i + "]";

            testIDList.add(Driver.getDriver().findElement(By.xpath(xpath)));

        }
        return testIDList;

    }

    public List<WebElement> testNameListOlustur() {
        List<WebElement> testNameList = new ArrayList<WebElement>();

        for (int i = 1; i < 247; i++) {
            String xpath = "(//tbody//tr//td[2])[" + i + "]";

            testNameList.add(Driver.getDriver().findElement(By.xpath(xpath)));

        }
        return testNameList;
    }


    //mainPage>myPages>myAppointments>EditButton>RequestATest Butonu>tablo basliklari
    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> baslikWebelementListesi;


    public List<WebElement> sutunListesiGetir(int index) {

        //     //tbody//tr//td[3]

        String dinamikXpath = "//tbody//tr//td[" + (index + 1) + "]";

        List<WebElement> istenenSutunWebelementleri = Driver.getDriver().findElements(By.xpath(dinamikXpath));

        return istenenSutunWebelementleri;

    }

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> viewResultTbody;


}