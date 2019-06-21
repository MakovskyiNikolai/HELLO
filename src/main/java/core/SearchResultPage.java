package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    @FindBys({
       @FindBy(xpath = "//div[@class='rc']//h3")
    })
    private List<WebElement> searchResultLinks;

    private WebDriver webDriver;

    public SearchResultPage(final WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public String getFirstSearchResultLinkText(){
        final Integer firstSearchResultLinksListIndex = 0;
        return searchResultLinks.get(0).getText();
    }
}
