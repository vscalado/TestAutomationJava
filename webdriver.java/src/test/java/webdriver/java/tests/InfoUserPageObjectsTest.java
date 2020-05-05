package webdriver.java.tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import webdriver.java.pages.LoginPage;
import webdriver.java.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InfoUserPageObjectsTest.csv")
public class InfoUserPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        //navegador = Web.createBrowserstack();
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarContatoUsuarios(
        @Param(name="login") String login,
        @Param(name="password") String senha,
        @Param(name="tipo") String tipo,
        @Param(name="contato") String contato,
        @Param(name="mensagem") String mensagem
        ){
        final String toastText = new LoginPage(
                navegador)
                .clickSignIn()
                //.typeLogIn("julio0001")
                //.typePassword("123456")
                //.clickSignIn();
                .makeLogIn(login, senha)
                .clickMe()
                .clickMoreDataAboutYou()
                .clickButtonAddMoreDataAboutYou()
                .addContact(tipo, contato)
                .captureToastText();
        assertEquals(mensagem, toastText);
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}