package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@class='gNO89b']")
    private WebElement searchButton;

    private WebDriver webDriver;

    public GoogleMainPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);      //передаю обьект своей страницы не нулл
    }

    public void typeSearchText(final String text) {
        searchInput.sendKeys(text);
    }

    public String getExpectedOkButtonText(){
        return searchButton.getText();
    }
    public SearchResultPage clickSearchButton(){
        searchButton.click();
        return new SearchResultPage(webDriver);
    }
}
