package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.TextBookPage;

import java.time.Duration;

public class SideMenu {
    private final WebDriver driver;
    private final By documentationLink = By.xpath("//a[@href='#_testng_documentation']");
    private final By textBookLink = By.xpath("//a[@href='#_the_testng_textbook_next_generation_java_testing']");
    private final By annotationsSubmenu = By.xpath("//a[@href='#_annotations']");

    public SideMenu(WebDriver driver) {
        this.driver = driver;
    }

    public TextBookPage openTextBook() {
        clickAndWait(textBookLink);
        return new TextBookPage(driver);
    }

    private void clickAndWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}
