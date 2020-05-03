package webdriver.java.tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriver.java.suporte.Generator;
import webdriver.java.suporte.Screenshot;
import webdriver.java.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InfoUserTest.csv")
public class InfoUserTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();
    @Before
    public void setUp(){
        navegador = Web.createChrome();
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
    }

    @Test
    public void testAdicionarContatoUsuario(@Param(name="tipo") final String tipo,
            @Param(name = "contato") final String contato, @Param(name = "mensagem") final String mensagemEsperada) {
        //Clicar no botão "+ADD MERE DATA" //div[@id="moredata"]/div/button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//div[@id=\"moredata\"]/div/button[@data-target=\"addmoredata\"]")).click();

        //Identificar onde esta o formulario de id=addmore-data
        final WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combo de name type, escolher a opção "Phone"
        final WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // No campo de name=contact digitar +5519991537896
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar No link de text SAVE que esta na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id toast-container validar que o texto é Your contact has been
        // added!
        final WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        final String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);
        //ScreenShot
        final String screenshotArquivo = "G:\\dev\\projects\\TestAutomationJava\\screenshots\\"
                + Generator.dataHoraParaArquivo() + "-" + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);
    }

    @Test
    public void testRemoverUmContatoUsuario(@Param(name="contatoRe") final String contato, @Param(name="mensagemRe") final String mensagemEsperada){
        //Clicar no  elemento pelo seu xpath "//span[text()="+5519991537896"]/following-sibling::a"
        final String contatoRemover = "//span[text()=\"" + contato + "\"]/following-sibling::a";
        //System.out.println(contatoRemover);
        navegador.findElement(By.xpath(contatoRemover)).click();

        //Confirmar a janela JavaScript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem "Rest in peace,dear phone!"
        final WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        final String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);

        final String screenshotArquivo = "G:\\dev\\projects\\TestAutomationJava\\screenshots\\"
                + Generator.dataHoraParaArquivo() + "-" + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);
        // Aguardar até 10 segundo para que a janela desapareça
        final WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        //Clicar no link com Text "Logout"
        navegador.findElement(By.linkText("Logout")).click();

    }
    
    @After
    public void tearDown(){
        //Fechar o Navegador
        navegador.quit();
    }
}