package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;



public class DATAProviderNEGATIFTest {


    @DataProvider
    public static Object[][] kullanicilar() {

        return new Object[][]{
                {"team11gmail.comcom", "Aktas03414.", "Aktas03414."}, {"", "Aktas03414.", "Aktas03414."}, {"Ahmettahmi47@gmail.com", "123", "123"}};
        }
        @Test(dataProvider = "kullanicilar")
        public void test01 (String registerEmailBox, String password, String confirmpassword) throws InterruptedException {
            //  http://spendinggood.com/ adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //Register  butonuna bas
            SpendingGoodPage spendinGoodPage = new SpendingGoodPage();
            SpendingGoodPage.register.click();

            SpendingGoodPage.BecomeVendor.click();
            //Data provider ile 3 farklı userEmail ve 3 farklı password girelim


            SpendingGoodPage.EmailBox.sendKeys((CharSequence) registerEmailBox);
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(password)
                    .sendKeys(confirmpassword)
                    .sendKeys(Keys.ENTER).perform();

            /*
            SpendingGoodPage.registerPasswordBox.sendKeys(ConfigReader.getProperty("password"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("confirmpassword")).sendKeys(Keys.ENTER).perform();


             */

            //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
            Assert.assertTrue(SpendingGoodPage.registrationSuccessfully.isDisplayed());
        }
    }



