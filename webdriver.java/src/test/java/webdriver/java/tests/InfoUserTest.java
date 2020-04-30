package webdriver.java.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfoUserTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoSuauario() {
        //Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver", "G:\\Path\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a pagina Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Clicar no link que possui o texto "Sign in"
        //navegador.findElement(By.linkText("Sign in")).click();
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        // Identificando o formulário de Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo name "Login" que esta dentro do formulario "Signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo name "Password" que esta dentro do formulario "Signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
        //Clicar no link com o texto "Sign in"
        formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento com class "me" esta o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);
        //Fechar o Navegador
        navegador.quit();
    }
}