package io.github.testsheepnz;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatePage {

    //Конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public CalculatePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Локатор поля выбора Build
    @FindBy(xpath = "//*[contains(@id, 'selectBuild')]")
    private WebElement selectBuild;
    //Локатор поля ввода первого значения
    @FindBy(xpath = "//*[contains(@id, 'number1Field')]")
    private WebElement number1Field;
    //Локатор поля ввода второго значения
    @FindBy(xpath = "//*[contains(@id, 'number2Field')]")
    private WebElement number2Field;
    //Локатор выбора операции
    @FindBy(xpath = "//*[contains(@id, 'selectOperationDropdown')]")
    private WebElement operationDrop;
    //Кнопка для вывода ответа
    @FindBy(xpath = "//*[contains(@id, 'calculateButton')]")
    private WebElement calculateBtn;
    //Локатор определения ответа на совершенную операцию
    @FindBy(xpath = "//*[contains(@id, 'numberAnswerField')]")
    private WebElement Answer;
    @FindBy(xpath = "//*[contains(@id, 'clearButton')]")
    private WebElement clearBtn;

    //Метод ввода первого и второго значения
    public void inputNumber(String oneVal, String twoVal){
        number1Field.sendKeys(oneVal);
        number2Field.sendKeys(twoVal);
    }
    public void clearText(){
        number1Field.clear();
        number2Field.clear();
    }
    //Метод нажатия на кнопку, для получения ответа
    public void clickOperationBtn(){
        calculateBtn.click();
    }
    public void clickClear(){
        clearBtn.click();
    }
    public void selectBuildClick(String opt){
        Select select = new Select(selectBuild);
        select.selectByVisibleText(opt);
    }
    public void selectOperationDrop(String opt){
        Select select = new Select(operationDrop);
        select.selectByVisibleText(opt);
    }

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void equalsAnswer(String testAnswer){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'numberAnswerField')]")));
        if (Answer.getAttribute("value").equals(testAnswer)){
            System.out.println("Match found");
        } else {
            System.out.println("Match Not Found");
        }
    }

}
