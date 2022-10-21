package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US001_TC003BOSEMAILnegativ extends TestBaseRapor {

    static SpendingGoodPage spendinGoodPage = new SpendingGoodPage();

    @Test
    public void bosEmail() throws InterruptedException {
        extentTest=extentReports.createTest("BosEmail","Kullanici Hesap Acma islemlerini yaparken Email kutusunu bos birakmamali");
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("Spendinggood anasayfaya gidildi");

        SpendingGoodPage.register.click();
        extentTest.info("Register butonuna tiklandi");

        SpendingGoodPage.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tiklandi");


        SpendingGoodPage.PasswordBox.sendKeys(ConfigReader.getProperty("password"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("confirmpassword")).sendKeys(Keys.ENTER).perform();


        Thread.sleep(2000);
        extentTest.info("Email kutusu bos birakildi password ve confirm password girilerek Registration butonuna tiklandi");

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");
        Assert.assertTrue(SpendingGoodPage.bosEmailHataMesaji.isDisplayed());
        Thread.sleep(5000);//
        extentTest.pass("Email kutusu bos birakildiginda ekranda hata mesaji ciktigi goruntulendi");

        Driver.getDriver().navigate().refresh();
    }










}
