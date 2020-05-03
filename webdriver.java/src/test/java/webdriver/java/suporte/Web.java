package webdriver.java.suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "G:\\Path\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navegando para a pagina Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }
    
}