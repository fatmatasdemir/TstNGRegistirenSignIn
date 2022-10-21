package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import tests.methods.VerificationCode;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_001VendorRegistration {


        @Test
        public void US001() throws InterruptedException {

            SpendingGoodPage page=new SpendingGoodPage();

            //1 - vendor http://spendinggood.com// sayfasina gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));

            //2 -  Register simgesine tiklar
            SpendingGoodPage.register.click();

            //3 - Acilan pencerede Becamo a vendor butonuna tiklayin
            SpendingGoodPage.BecomeVendor.click();


            //4 - Registration'in email , password , confirm pasword gorunur oldugunu dogrular
            Assert.assertTrue(SpendingGoodPage.EmailBox.isDisplayed()
                    && SpendingGoodPage.PasswordBox.isDisplayed()
                    && SpendingGoodPage.ConfirmPwdBox.isDisplayed());


            //5 - Gecerli email adresi girin
            //6 - Email adresine gelen dogrulama kodunu verfication code'a girer
            VerificationCode.getEmailCode(); // method


            //7 - Gecerli sifre olusturun ve pasword ve confirm password'e ayni sifreyi girin ve Register Butonuna tiklayi

            SpendingGoodPage.PasswordBox.sendKeys(ConfigReader.getProperty("password"));
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("confirmpassword")).sendKeys(Keys.ENTER).perform();


            //8 - Registration Successfully Completed. mesajinin goruntulendigini dogrulayin
            Assert.assertTrue(SpendingGoodPage.registrationSuccessfully.isDisplayed());
            ReusableMethods.waitFor(2);


            //9 Not Right now butonuna tiklayin
            SpendingGoodPage.notRightNowButton.click();

            //10- Store Manager'in goruntulendigini dogrulayin.
            Assert.assertTrue(SpendingGoodPage.storeManagerTitle.isDisplayed());

            // 11 Logout simgesine tiklar
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", SpendingGoodPage.LogoutButton);
            jse.executeScript("arguments[0].click()", SpendingGoodPage.LogoutButton);

            Thread.sleep(3000);


            //12 Anasayfada SIGN IN simgesine tiklar
            SpendingGoodPage.ilksignButton.click();
            Thread.sleep(4000);

            //13 Gecerli Email ve Password girer ve SIGN IN butonuna tiklar
            SpendingGoodPage.SignemailBox.sendKeys(ConfigReader.getProperty("mail"));
            actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("Password"))
                    .sendKeys(Keys.ENTER).perform();


            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //14 My Account simgesine tiklar
            SpendingGoodPage.myAccountLink.click();
            //15 My Account göründügünü test eder
            Assert.assertTrue(SpendingGoodPage.myAccountLink.isDisplayed());
            Assert.assertTrue(SpendingGoodPage.myAccountTitle.isDisplayed());

            ReusableMethods.waitFor(2);

            //Driver.getDriver().quit();



        }
    }




