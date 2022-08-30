package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin={"html:target/cucumber-html-reports/UI_cucumber.html", // buradaki / \\ idi, degistirdim, emin degilim
                "json:target/json-reports/UI_cucumber.json",
                "junit:target/xml-report/UI_cucumber.xml"}, // bu satir ile html,xml,json report olusturabiliyoruz
        features = "src/test/resources/features/UiFeatures", // YENI FERATURE OLUSTURURSAN BURAYI GUNCELLE
        glue = "stepDefinitions/Ui",
        tags = "@mamet",
        dryRun = false
        // step definition olusturmak icin calistirdiginda burayı true yapmayi unutma
)

public class UIRunner
{
    // !!!!! EGER API VE DB ICIN FARKLI FEATURE FILE'LAR OLUSTURURSAN 145. SATIRDAKI FEATURES KISMINDAKİ PATH'I
    // GUNCELLEMEN GEREK !!!!!
}
