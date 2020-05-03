package webdriver.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage extends BasePage{

    public SecretPage(WebDriver navegador) {
        super(navegador);
        // TODO Auto-generated constructor stub
    }

    public MePage clickMe(){
        navegador.findElement(By.className("me")).click();

        return new MePage(navegador);
    }
}
