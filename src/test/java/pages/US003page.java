package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class US003page {
    //public US003_Pages() {PageFactory.initElements(Driver.getDriver(), this);}
    public US003page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement userIsareti;
    //public static WebElement register= Driver.getDriver().findElement(By.xpath("(//*[@data-icon='sign-in-alt'])[2]"));
    @FindBy(xpath = "(//*[@data-icon='sign-in-alt'])[2]")
    public WebElement register;
    //public WebElement passwordBox= Driver.getDriver().findElement(By.xpath("//input[@id='firstPassword']"));
    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@style='background-color: rgb(255, 0, 0);']")
    public WebElement strenghtBar1_sönük;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[1]")
    public WebElement strenghtBar2_sönük;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[2]")
    public WebElement strenghtBar3_sönük;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[3]")
    public WebElement strenghtBar4_sönük;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[4]")
    public WebElement strenghtBar5_sönük;


   /* WebElement strenghtBar1_sönük=Driver.getDriver().findElement(By.xpath("//*[@style='background-color: rgb(255, 0, 0);']"));
     WebElement strenghtBar2_sönük=Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[1]"));
     WebElement strenghtBar3_sönük=Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[2]"));
     WebElement strenghtBar4_sönük=Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[3]"));
     WebElement strenghtBar5_sönük=Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[4]"));
     */


    @FindBy(xpath = "//*[@style='background-color: rgb(255, 153, 0);']")
    public WebElement strenghtBar1_yanik_turuncu;
    @FindBy(xpath = "(//*[@style='background-color: rgb(255, 153, 0);'])[2]")
    public WebElement strenghtBar2_yanik_turuncu;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[1]")
    public WebElement strenghtBar3_sönük_turuncu;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[2]")
    public WebElement strenghtBar4_sönük_turuncu;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[3]")
    public WebElement strenghtBar5_sönük_turuncu;





  /* WebElement strenghtBar1_yanik_turuncu = Driver.getDriver().findElement(By.xpath("//*[@style='background-color: rgb(255, 153, 0);']"));
    WebElement strenghtBar2_yanik_turuncu = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(255, 153, 0);'])[2]"));
    WebElement strenghtBar3_sönük_turuncu = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[1]"));
    WebElement strenghtBar4_sönük_turuncu = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[2]"));
    WebElement strenghtBar5_sönük_turuncu = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[3]"));
    */

    @FindBy(xpath = "//*[@style='background-color: rgb(153, 255, 0);']")
    public WebElement strenghtBar1_yanik_yesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(153, 255, 0);'])[2]")
    public WebElement strenghtBar2_yanik_yesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(153, 255, 0);'])[3]")
    public WebElement strenghtBar3_yanik_yesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(153, 255, 0);'])[4]")
    public WebElement strenghtBar4_yanik_yesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(221, 221, 221);'])[1]")
    public WebElement strenghtBar5_sönük_yesil;




    /*WebElement strenghtBar1_yanik_yesil = Driver.getDriver().findElement(By.xpath("//*[@style='background-color: rgb(153, 255, 0);']"));
    WebElement strenghtBar2_yanik_yesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(153, 255, 0);'])[2]"));
    WebElement strenghtBar3_yanik_yesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(153, 255, 0);'])[3]"));
    WebElement strenghtBar4_yanik_yesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(153, 255, 0);'])[4]"));
    WebElement strenghtBar5_sönük_yesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(221, 221, 221);'])[1]"));
    */


    @FindBy(xpath = "(//*[@style='background-color: rgb(0, 255, 0);'])[1]")
    public WebElement strenghtBar1_yanik_tamyesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(0, 255, 0);'])[2]")
    public WebElement strenghtBar2_yanik_tamyesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(0, 255, 0);'])[3]")
    public WebElement strenghtBar3_yanik_tamyesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(0, 255, 0);'])[4]")
    public WebElement strenghtBar4_yanik_tamyesil;
    @FindBy(xpath = "(//*[@style='background-color: rgb(0, 255, 0);'])[5]")
    public WebElement strenghtBar5_yanik_tamyesil;

    /*
    WebElement strenghtBar1_yanik_tamyesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(0, 255, 0);'])[1]"));
    WebElement strenghtBar2_yanik_tamyesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(0, 255, 0);'])[2]"));
    WebElement strenghtBar3_yanik_tamyesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(0, 255, 0);'])[3]"));
    WebElement strenghtBar4_yanik_tamyesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(0, 255, 0);'])[4]"));
    WebElement strenghtBar5_yanik_tamyesil = Driver.getDriver().findElement(By.xpath("(//*[@style='background-color: rgb(0, 255, 0);'])[5]"));

    */


}
