package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US001_GecersizEmail extends TestBaseRapor {



    static SpendingGoodPage spendinGoodPage = new SpendingGoodPage();

    @Test  //CALISTI
    public void gecersizEmail() throws InterruptedException {
        extentTest=extentReports.createTest("GecersizEmail","Kullanici Hesap Acma islemlerini yaparken gecerli bir Email girmeli");
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("Spendinggood anasayfaya gidildi");
        Thread.sleep(2000);
        SpendingGoodPage.register.click();
        extentTest.info("Register butonuna tiklandi");
       SpendingGoodPage.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tiklandi");

    /*  SpendingGoodPage.Email.sendKeys(ConfigReader.getProperty("WrongEmail"));
       SpendingGoodPage.password.sendKeys(ConfigReader.getProperty("password"));
        SpendingGoodPage.confirmpassword.sendKeys(ConfigReader.getProperty("confirmpassword"));
    SpendingGoodPage.registerbutton.click();  */


      SpendingGoodPage.EmailBox.sendKeys(ConfigReader.getProperty("WrongEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).
                sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("confirmpassword"))
                .sendKeys(Keys.ENTER).perform();



        extentTest.info("Gecersiz Email girildi ve Registration butonuna tiklandi");

        Thread.sleep(4000);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");
        Assert.assertTrue(SpendingGoodPage.gecersizEmailHataMesaji.isDisplayed());//
        extentTest.pass("Gecersiz Email girildiginde ekranda hata mesaji ciktigi goruntulendi");

        //Driver.getDriver().navigate().refresh();

    }












}
