package page;

import components.SideMenu;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private SideMenu sideMenu;

    public SideMenu getSideMenu() {
        return new SideMenu(driver);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openHomePage() {
        driver.get("https://testng.org/");
        return this;
    }
}