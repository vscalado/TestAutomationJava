package webdriver.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver navegador) {
        super(navegador);

    }
    // Metódos Estruturais, tem mais liberdade para alterar apenas um dado.
    public LoginFormPage typeLogIn(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }

    public LoginFormPage typePassword(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public SecretPage clickSignIn(){
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new SecretPage(navegador);
    }
    //Método Funcional, agrupa todos os metodos para executar uma ação completa.
    public SecretPage makeLogIn(String login, String password){
        //navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        //navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        //navegador.findElement(By.linkText("SIGN IN")).click();

        typeLogIn(login);
        typePassword(password);
        clickSignIn();

        return new SecretPage(navegador);
    }
}
