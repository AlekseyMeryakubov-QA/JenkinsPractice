import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import static io.restassured.RestAssured.given;

public class TestForJenkins {

    private WebDriver driver;

    @Test
    void textBookTest() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        String imageSrc = new HomePage(driver)
                .openHomePage()
                .getSideMenu()
                .openTextBook()
                .getBookCoverSrc();

        Assertions.assertTrue(
                imageSrc.endsWith(".jpg") || imageSrc.contains(".jpg?"));
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void getPingTest() {
        //@formatter:off
        given()
                .baseUri("https://restful-booker.herokuapp.com")
        .when()
                .get( "/ping")
        .then()
                .statusCode(HttpStatus.SC_CREATED);
        //@formatter:on
    }
}
