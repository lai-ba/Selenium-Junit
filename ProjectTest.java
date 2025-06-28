import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProjectTest {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    @DisplayName("Fill up the user form")

    public void fillupForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");


        List<WebElement> input=driver.findElements(By.className("form-control"));
        input.get(0).sendKeys("Laiba");
        input.get(1).sendKeys("0162*******");
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String todayDate = LocalDate.now().format(formatter);
        input.get(2).sendKeys(todayDate);
        input.get(3).sendKeys("laiba@gmail.com");
        input.get(4).sendKeys("I'm just a girl in my world");
        WebElement uploadfile=driver.findElement(By.cssSelector("#edit-uploadocument-upload"));
        uploadfile.sendKeys("C:\\Users\\Asus\\Desktop\\barbie.jpg");
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 900);");

        WebElement checkbox=driver.findElement(By.id("edit-age"));
        Actions actions=new Actions(driver);
        actions.moveToElement(checkbox).click().perform();
        WebElement submitBtn = driver.findElement(By.id("edit-submit"));
        Actions actions2=new Actions((driver));
        actions2.moveToElement(submitBtn).click().perform();

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement title=driver.findElement(By.cssSelector("div.region.region-title"));
        String actualmessage=title.getText().trim();
        String expectedMessage="Thank you for your submission!";
        Assertions.assertTrue(actualmessage.contains(expectedMessage));*/



    }

}

