package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public abstract class ReusableMethods {
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "target/Screenshots" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static String getScreenshotForUS007(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/US07_test-output/ScreenShots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //   HARD WAIT WITH THREAD.SLEEP
//   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============Explicit Wait==============//
    // public static WebElement waitForVisibility(WebElement element, int timeout) {
    //     WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
    //     return wait.until(ExpectedConditions.visibilityOf(element));
    // }
    // public static WebElement waitForVisibility(By locator, int timeout) {
    //     WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
    //     return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    // }
    // public static WebElement waitForClickablility(WebElement element, int timeout) {
    //     WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
    //     return wait.until(ExpectedConditions.elementToBeClickable(element));
    // }
    // public static WebElement waitForClickablility(By locator, int timeout) {
    //     WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
    //     return wait.until(ExpectedConditions.elementToBeClickable(locator));
    // }
    // public static void clickWithTimeOut(WebElement element, int timeout) {
    //     for (int i = 0; i < timeout; i++) {
    //         try {
    //             element.click();
    //             return;
    //         } catch (WebDriverException e) {
    //             waitFor(1);
    //         }
    //     }
    // }
    //  public static void waitForPageToLoad(long timeout) {
    //      ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
    //          public Boolean apply(WebDriver driver) {
    //              return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    //          }
    //      };
    //      try {
    //          System.out.println("Waiting for page to load...");
    //          WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
    //          wait.until(expectation);
    //      } catch (Throwable error) {
    //          System.out.println(
    //                  "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
    //      }
    //  }
    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeout) {
        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver()).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(3))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(1));//Check for the element every 1 second
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }
    //========WebElement Screenshot=============//

    public static String WebEgetScreenshot(String name, WebElement elementismi) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        // TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = elementismi.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    private static WebDriver driver = Driver.getDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //  public static void clickElement(WebElement clickElement) {
    //      wait.until(ExpectedConditions.elementToBeClickable(clickElement));
    //      clickElement.click();
    //  }

    //  public static void sendKeysElement(WebElement sendKeysElement, String value) {
    //      wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
    //      sendKeysElement.sendKeys(value);
    //  }

    //  public static void selectElementFromDropdown(WebElement dropdown, String element) {
    //      Select slc = new Select(dropdown);
    //      slc.selectByVisibleText(element);
    //  }

    //  public static void AssertionEquals(WebElement actual, String expected) {
    //      wait.until(ExpectedConditions.visibilityOf(actual));
    //      Assert.assertEquals(actual.getText(), expected);

    //  }
    //  public static void AssertionTrue(WebElement actual, String expected) {
    //      wait.until(ExpectedConditions.visibilityOf(actual));
    //      Assert.assertTrue(actual.getText().contains(expected));
    //      System.out.println("My Message : " + actual.getText());
    //  }
    public static void ListWEGetTexPrint(List<WebElement> list) {
        for (WebElement w : list) {
            System.out.println("w.getText() = " + w.getText());
        }
    }

    public static void ListWEClick(List<WebElement> list) {
        for (WebElement w : list) {
            w.click();
        }
    }


    public static void jsScroll() {

        JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();
        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }


    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollDownWithJS() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);

    }

    public static void clickWithJS(WebElement webElement) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);

        js.executeScript("arguments[0].click();", webElement);

    }

    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollUpWithJS() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        Thread.sleep(3000);

    }


    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    //OSMAN tarafindan eklenen


    public static String setTheDate(String format, int atMostDay, int atMostMonth, int atMostYear) {
        // verilen gun ay yıl kadar oncesine gidip tarih olusturur
        // verilen gun ay yıl kadar sonrasına gidip tarih olusturur
        // Date date = new Date();
        // DateFormat tarih = new SimpleDateFormat("dd-MM-yyy");
        // hangi class'i kullanarak formatlama yaparsan yap, formatlanan date Stringe donusur
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        date = date.plusYears(atMostYear).plusMonths(atMostMonth).plusDays(atMostDay);
        String dateF = formatter.format(date);

  //  public static void hooverByJS(WebElement element) {
  //      JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
  //      jse.executeScript("arguments[0].scrollIntoView()", element);
  //      jse.executeScript("arguments[0].click();", element);
  //  }
//

        return dateF;
    }

    public static String setTheDateByRandom(String format, int atMostYear, String direction) {

        int day = (int) (Math.random() * 366 + 1);
        int month = (int) (Math.random() * 13 + 1);
        int year = (int) (Math.random() * atMostYear + 1);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        direction = direction.toUpperCase(Locale.ROOT);
        String dateF;

        switch (direction) {
            case "FEATURE":
                date = date.plusYears(year).plusMonths(month).plusDays(day);
                dateF = formatter.format(date);
                return dateF;


            case "PAST":
                date = date.minusYears(year).minusMonths(month).minusDays(day);
                dateF = formatter.format(date);
                return dateF;

            default:
                dateF = formatter.format(date);
                return dateF;

        }
    }

    public static String setTheDateByRandomWithTime(String format, int atMostYear, String direction) {

        int day = (int) (Math.random() * 366 + 1);
        int month = (int) (Math.random() * 13 + 1);
        int year = (int) (Math.random() * atMostYear + 1);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        direction = direction.toUpperCase(Locale.ROOT);
        String dateF;

        switch (direction) {
            case "FEATURE":
                dateTime = dateTime.plusYears(year).plusMonths(month).plusDays(day);
                dateF = formatter.format(dateTime);
                return dateF;

            case "PAST":
                dateTime = dateTime.minusYears(year).minusMonths(month).minusDays(day);
                dateF = formatter.format(dateTime);
                return dateF;

            default:
                dateF = formatter.format(dateTime);
                return dateF;

        }
    }

    public static String stringDateFormat(String date) {
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6);

        String formatDateString = year + "-" + month + "-" + day;

        return formatDateString;

        // buraya gelen  gun ay yil gg.aa.yyyy
        // 2030-01-01  yıl ay gun olmalı

    }

    public static void hooverByJS(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", element);
        jse.executeScript("arguments[0].click();", element);
    }
}








