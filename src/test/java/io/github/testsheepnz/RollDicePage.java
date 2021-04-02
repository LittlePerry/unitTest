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

public class RollDicePage {
    public WebDriver driver;
    public RollDicePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[contains(@id, 'buildNumber')]")
    private WebElement selectBuild;
    @FindBy(xpath = "//*[contains(@id, 'rollDiceButton')]")
    private WebElement rollBtn;
    @FindBy(xpath = "//*[contains(@id, 'numberGuess')]")
    private WebElement numberGuess;
    @FindBy(xpath = "//*[contains(@id, 'submitButton')]")
    private WebElement subBtn;
    @FindBy(xpath = "//*[@id=\"feedbackLabel\"]/font/b/i")
    private WebElement answer;

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void selectBuildClick(String opt){
        Select select = new Select(selectBuild);
        select.selectByVisibleText(opt);
    }
    public void roll(){
        rollBtn.click();
    }
    public void numGuess(String opt){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'numberGuess')]")));
        numberGuess.sendKeys(opt);
    }
    public void sub(){
        subBtn.click();
    }
    public void equalsAnswer(String testAnswer){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"feedbackLabel\"]/font/b/i")));
        if (answer.getText().equals(testAnswer)){
            System.out.println("Match found");
        } else {
            System.out.println("Match Not Found");
        }
    }


}
