package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US_001NegativTestVendorHesapAcma extends TestBaseRapor {


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


        SpendingGoodPage. PasswordBox.sendKeys(ConfigReader.getProperty("password"));
      SpendingGoodPage.ConfirmPwdBox.sendKeys(ConfigReader.getProperty("confirmpassword"));
      SpendingGoodPage.registerbutton.click();
         Thread.sleep(2000);
        extentTest.info("Email kutusu bos birakildi password ve confirm password girilerek Registration butonuna tiklandi");

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");

        Assert.assertTrue(SpendingGoodPage.bosEmailHataMesaji.isDisplayed());
        ReusableMethods.waitFor(4);
        extentTest.pass("Email kutusu bos birakildiginda ekranda hata mesaji ciktigi goruntulendi");

        Driver.getDriver().navigate().refresh();

    }


    @Test
    public void gecersizEmail() throws InterruptedException {
        extentTest=extentReports.createTest("GecersizEmail","Kullanici Hesap Acma islemlerini yaparken gecerli bir Email girmeli");
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("Spendinggood anasayfaya gidildi");

       SpendingGoodPage.register.click();
        extentTest.info("Register butonuna tiklandi");
        ReusableMethods.waitFor(3);
     SpendingGoodPage.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tiklandi");


        SpendingGoodPage.EmailBox.sendKeys(ConfigReader.getProperty("WrongEmail"));
       SpendingGoodPage.PasswordBox.sendKeys(ConfigReader.getProperty("password"));
       SpendingGoodPage.ConfirmPwdBox.sendKeys(ConfigReader.getProperty("confirmpassword"));
       SpendingGoodPage.registerbutton.click();
       extentTest.info("Gecersiz Email girildi ve Registration butonuna tiklandi");

        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");

        Assert.assertTrue(SpendingGoodPage.gecersizEmailHataMesaji.isDisplayed());//
        extentTest.pass("Gecersiz Email girildiginde ekranda hata mesaji ciktigi goruntulendi");

        Driver.getDriver().navigate().refresh();

    }


    @Test
    public void GecersizPassword() throws InterruptedException {
        extentTest=extentReports.createTest("GecersizPassword","Kullanici Gulch Password girmeden Vendor hesabi olusturamamali");
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("Spendinggood anasayfaya gidildi");

      SpendingGoodPage.register.click();
        extentTest.info("Register butonuna tiklandi");
       ReusableMethods.waitFor(3);
        SpendingGoodPage.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tiklandi");

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();
        actions.click(SpendingGoodPage.EmailBox)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .perform();
        extentTest.info("email kutusu butonuna tiklandi ve faker class ile unique ve gecerli bir email girildi");

        SpendingGoodPage.PasswordBox.sendKeys(ConfigReader.getProperty("WrongPassword"));
     SpendingGoodPage.ConfirmPwdBox.sendKeys(ConfigReader.getProperty("WrongConfirmPassword"));
       SpendingGoodPage.registerbutton.click();
       extentTest.info("Password ve Confirm Password kutusuna Gulch olmayan sifre girildi");
        ReusableMethods.waitFor(4);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");

        Assert.assertTrue(SpendingGoodPage.gecersizPasswordHataliMesaji.isDisplayed());
        extentTest.pass("Kullanici Gulch Password girmedigi icin kayit yapilamadi");
      //  Driver.closeDriver();

    }

}





