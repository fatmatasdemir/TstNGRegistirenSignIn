package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SpendingGoodPage {




    public SpendingGoodPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    // sign in

    @FindBy(css = ".login.inline-type")
    public static WebElement ilksignButton;

    @FindBy(xpath = "//*[@id='username']")
    public static WebElement SignemailBox;

    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(css = ".woocommerce-form-login__submit")
    public WebElement ikinciSignIn;
    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public static WebElement myAccountLink;

    @FindBy(css = "div>h2.page-title")
    public static WebElement myAccountTitle;


    //REGISTER LOCATE ///

    @FindBy(css = ".register.inline-type")
    public static WebElement register;
    @FindBy(xpath = "//*[text()='Become a Vendor']  ")
    public static WebElement BecomeVendor;
    @FindBy(xpath = "//*[@id='user_email']")
    public static WebElement EmailBox;
    @FindBy(css = "#passoword")
    public static WebElement PasswordBox;
    @FindBy(xpath = " //input[@id='passoword'] ")
    public static WebElement ConfirmPwdBox;
    @FindBy(css = ".wcfm_email_verified_input")
    public static WebElement verificationCodeBox;
    @FindBy(css = ".wcfm-message.wcfm-success")
    public static WebElement registrationSuccessfully;
    @FindBy(xpath = "//*[.='Not right now']")
    public static WebElement notRightNowButton;
    @FindBy(css = ".page-title")
    public static WebElement storeManagerTitle;
    @FindBy(xpath = "//*[@id=\"wcfm_menu\"]/div[18]/a/span[2]")
    public static WebElement LogoutButton;

    /////VENDOR HESABI NEGATIF TESTLER ICIN  ////

    @FindBy(xpath = "//input[@id='wcfm_membership_register_button']")
    public static WebElement registerbutton;
    @FindBy(xpath = "//*[text()='Email: This field is required.']")
    public static WebElement bosEmailHataMesaji;

    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public static WebElement gecersizEmailHataMesaji;

    @FindBy(xpath ="//*[text()='Registration Successfully Completed.']")
    public static WebElement gecersizPasswordHataliMesaji;

    /////////////////////////////////////////////////////////////
    //verification code div.email method classi
    @FindBy(css = "div.email")
    public static WebElement geciciEmail;
    @FindBy(css = "a#renew")
    public WebElement emailBoxRefresh;
    @FindBy(xpath = "//tbody//tr[1]")
    public static WebElement geciciEmailBox;
    @FindBy(xpath = "//tbody//tr[2]")
    public WebElement onayEmail;
    @FindBy(xpath = "//*[@id='body_content_inner']")
    public static WebElement verificationCode;
    @FindBy(xpath = "//*[.='Visit now ...']")
    public WebElement visitNow;

    //===============================
    //MY ACCOUNT SOL TARAFTAKI BASLIK LOCATELERI ///
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[1]/a")
    public WebElement Dashboard;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[2]/a")
    public WebElement StoreManager;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[3]/a")
    public static WebElement Orders;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[4]/a")
    public WebElement Dowlands;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[5]/a")
    public WebElement Adresses;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[6]/a")
    public WebElement Acoountdetails;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[7]/a")
    public WebElement Wishlist;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[8]/a")
    public WebElement SupportTickets;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[9]/a")
    public WebElement Followings;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[10]/a")
    public WebElement Logout;

    @FindBy(css = ".icon-box.text-center>a>p")
    public List<WebElement> myAccountPageList;

    @FindBy(css = ".woocommerce-MyAccount-navigation>ul>li")
    public List<WebElement> dashboardList;

    @FindBy(css = ".woocommerce-MyAccount-navigation.col-md-3")
    public WebElement dashBoardList;

    //negativelogin
    @FindBy(xpath = "//p[.='Wrong username or password.']")
    public WebElement wrongSignInText;







}