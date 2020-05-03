package webdriver.java.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import webdriver.java.pages.LoginPage;
import webdriver.java.suporte.Web;

public class InfoUserPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarContatoUsuario(){
        new LoginPage(navegador)
                .clickSignIn()
                //.typeLogIn("julio0001")
                //.typePassword("123456")
                //.clickSignIn();
                .makeLogIn("julio0001", "123456")
                .clickMe()
                .clickMoreDataAboutYou()
                .clickButtonAddMoreDataAboutYou()
                ;


    }

    @After
    public void tearDown(){
       // navegador.quit();
    }
}