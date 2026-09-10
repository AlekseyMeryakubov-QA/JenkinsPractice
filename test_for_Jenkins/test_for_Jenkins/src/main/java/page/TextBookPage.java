package page;

import components.SideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBookPage {

    private final WebDriver driver;
    private final By imgBookLocator = By.xpath("//img[@alt='book cover']");

    private SideMenu sideMenu;

    public SideMenu getSideMenu() {
        return new SideMenu(driver);
    }

    public TextBookPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBookCoverSrc() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(imgBookLocator));
        return image.getAttribute("src");
    }
}
