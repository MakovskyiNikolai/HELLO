import core.GoogleMainPage;
import core.SearchResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSuite {

  private WebDriver driver;

  @Before
  public void setDriver(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @After
  public void driverClose(){
    driver.close();
  }

  @Test
  public void checkGoogleMainPageIsOpened(){
    final String expectedTitle = "Google";
    driver.get("https://google.com");
    final String actualTitle = driver.getTitle();
    Assert.assertEquals("Title is incorrect", expectedTitle, actualTitle);
  }

  @Test
  public void checkGoogleSearchFunctionality(){
    final String expectedFirstLinkText = "курси IT-технологій - Комп'ютерна школа Hillel у Києві";
    //1. Открываем главную страницу Google
    driver.get("https://google.com");
    //2. Создаем обьект главной страницы Google
    final GoogleMainPage page = new GoogleMainPage(driver);
    //3. Вводим искомое слово в поисковик
    page.typeSearchText("Hillel");
    //4. Возвращаем новую страницу с результатами поиска
    final SearchResultPage searchResultPage = page.clickSearchButton();
    //5. Получаем текст первой ссылки со списка результатов
    final String actualFirstLinkText = searchResultPage.getFirstSearchResultLinkText();
    //6. Сравниваем ожидаемый и реальный текст
    Assert.assertEquals("Incorrecе first link text", expectedFirstLinkText, actualFirstLinkText);
  }
}
