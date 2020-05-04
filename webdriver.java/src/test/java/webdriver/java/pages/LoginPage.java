package webdriver.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(final WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage clickSignIn() {
        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();
        //final WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        //linkSignIn.click();
        return new LoginFormPage (navegador);
    }
}