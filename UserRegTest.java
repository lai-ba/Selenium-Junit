import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRegTest {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    @DisplayName("Fill up the user form")
    public void visitURL() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        Thread.sleep(5);
        WebElement input1=driver.findElement(By.id("first_name"));
        input1.sendKeys("Faria");
        WebElement input2=driver.findElement(By.id("last_name"));
        input2.sendKeys("Laiba");
        WebElement input3=driver.findElement(By.id("user_email"));
        input3.sendKeys("fl@blabla.com");
        WebElement pass=driver.findElement(By.id("user_pass"));
        pass.sendKeys("1234@abc");
        String dateToSet = "2000-05-15";
        WebElement dateInput = driver.findElement(By.cssSelector("input[data-label='Date of Birth']"));
        String date = "2000-01-27";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + dateToSet + "';", dateInput);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", dateInput);
        WebElement input4=driver.findElement(By.id("input_box_1665629217"));
        input4.sendKeys("Bangladeshi");
        Select country=new Select(driver.findElement(By.id("country_1665629257")));
        country.selectByValue("AL");
        WebElement phone=driver.findElement(By.id("phone_1665627880"));
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='(012) 908-7678';", phone);
        WebElement arrivedate = driver.findElement(By.id("date_box_1665629845"));
        String dates = "2025-06-27";

        JavascriptExecutor jsd = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + dates + "';", arrivedate);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", arrivedate);

        WebElement lenofStay=driver.findElement(By.id("number_box_1665629930"));
        lenofStay.sendKeys("2");

        WebElement RoomNo=driver.findElement(By.id("input_box_1665630010"));
        RoomNo.sendKeys("1");

        WebElement radiobtn1=driver.findElement(By.id("radio_1665627931_Yes"));
        radiobtn1.click();

        WebElement roompref=driver.findElement(By.id("radio_1665627997_Single Room"));
        roompref.click();

        WebElement dietres=driver.findElement(By.id("radio_1665628131_Nut Allergy"));
        dietres.click();

        Select activies=new Select(driver.findElement(By.id("select_1665628361")));
        activies.selectByValue("Town Hall");

        WebElement checkbox=driver.findElement(By.id("privacy_policy_1665633140"));
        checkbox.click();
        Thread.sleep(5);

        WebElement button = driver.findElement(By.tagName("button"));

        JavascriptExecutor jst = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);


        /*WebElement title=driver.findElement(By.id("ur-submit-message-node"));
        String actualmessage=title.getText().trim();
        String expectedMessage="User successfully registered.";
        Assertions.assertTrue(actualmessage.contains(expectedMessage));*/









    }
}
