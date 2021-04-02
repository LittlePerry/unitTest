package io.github.testsheepnz;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DiceTest {
    public static RollDicePage rollDicePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        //Определение пути до драйвера
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("operadriver"));
        //Создание экземпляра драйвера
        driver = new ChromeDriver();
        rollDicePage = new RollDicePage(driver);
        //Окно развернуть на полный экран
        driver.manage().window().maximize();
        //Задержка на выполнения теста = 10сек
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Получение ссылки из фала с настройками
        driver.get(ConfProperties.getProperty("rolldicePage"));
    }

    @Test
    public void testCaseThree(){
        rollDicePage.scroll();
        rollDicePage.selectBuildClick("Demo");
        rollDicePage.roll();
        rollDicePage.numGuess("String");
        rollDicePage.sub();
        rollDicePage.equalsAnswer("String: Not a number!");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
