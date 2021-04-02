package io.github.testsheepnz;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SubtractTest {
    public static CalculatePage calculatePage;
    public static WebDriver driver;
    //Первоначальная настройка
    @BeforeClass
    public static void setUp(){
        //Определение пути до драйвера
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //Создание экземпляра драйвера
        driver = new ChromeDriver();
        calculatePage = new CalculatePage(driver);
        //Окно развернуть на полный экран
        driver.manage().window().maximize();
        //Задержка на выполнения теста = 10сек
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Получение ссылки из фала с настройками
        driver.get(ConfProperties.getProperty("calculatePage"));
    }
    @Test
    public void testCaseOne(){
        calculatePage.scroll();
        calculatePage.selectBuildClick("Prototype");
        calculatePage.inputNumber("2","3");
        calculatePage.selectOperationDrop("Subtract");
        calculatePage.clickOperationBtn();
        calculatePage.equalsAnswer("-1");
        calculatePage.clickClear();
        calculatePage.clearText();

    }
    @Test
    public void testCaseTwo(){
        calculatePage.scroll();
        calculatePage.selectBuildClick("Prototype");
        calculatePage.inputNumber("gs","bu");
        calculatePage.selectOperationDrop("Concatenate");
        calculatePage.clickOperationBtn();
        calculatePage.equalsAnswer("gsbu");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
