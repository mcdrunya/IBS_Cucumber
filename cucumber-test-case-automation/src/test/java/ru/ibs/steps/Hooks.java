package ru.ibs.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.ConfProperties;
import ru.ibs.selenium.FoodPage;

import java.time.Duration;

public class Hooks {

    public static FoodPage foodPage;
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void before_all() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        foodPage = new FoodPage(driver);

        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("page_url"));
    }

    @After("@ui")
    public static void after_all(){
       driver.quit();
    }
}

