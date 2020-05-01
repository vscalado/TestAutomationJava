package webdriver.java.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InfoUserTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        //Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver", "G:\\Path\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a pagina Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoSuauario() {
        //Clicar no link que possui o texto "Sign in"
        //navegador.findElement(By.linkText("Sign in")).click();
        final WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        // Identificando o formulário de Login
        final WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo name "Login" que esta dentro do formulario "Signinbox" o
        // texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo name "Password" que esta dentro do formulario "Signinbox" o
        // texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
        // Clicar no link com o texto "Sign in"
        formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

        //Clicar em link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //Clicar no botão "+ADD MERE DATA" //div[@id="moredata"]/div/button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//div[@id=\"moredata\"]/div/button[@data-target=\"addmoredata\"]")).click();

        //Identificar onde esta o formulario de id=addmore-data
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Na combo de name type, escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        // No campo de name=contact digitar +5519991537896
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5519991537896");

        // Clicar No link de text SAVE que esta na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id toast-container validar que o texto é Your contact has been added!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);
    }

    @After
    public void tearDown(){
        //Fechar o Navegador
        navegador.quit();
    }
}