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
import utilities.TestBaseRapor;

import java.time.Duration;

public class US001GecersizPassword  extends TestBaseRapor{
/*
    static SpendingGoodPage spendinGoodPage = new SpendingGoodPage();


    @Test
    public void GecersizPassword() throws InterruptedException {
        extentTest=extentReports.createTest("GecersizPassword","Kullanici Gulch Password girmeden Vendor hesabi olusturamamali");
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("Spendinggood anasayfaya gidildi");

     SpendingGoodPage.register.click();
        extentTest.info("Register butonuna tiklandi");
       SpendingGoodPage.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tiklandi");

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        String fakeMail=faker.internet().emailAddress();
        actions.click(SpendingGoodPage.Email)

                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .perform();
        extentTest.info("email kutusu butonuna tiklandi ve faker class ile unique ve gecerli bir email girildi");


   SpendingGoodPage.password.sendKeys(ConfigReader.getProperty("WrongPassword"));
      SpendingGoodPage.confirmpassword.sendKeys(ConfigReader.getProperty("WrongConfirmPassword"));
SpendingGoodPage.registerbutton.click();
        Thread.sleep(2000);

        extentTest.info("Password ve Confirm Password kutusuna Gulch olmayan sifre girildi");

        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");



        extentTest.pass("Kullanici Gulch Password girmedigi icin kayit yapilamadi");
       // Driver.closeDriver();

    }



*/








}
