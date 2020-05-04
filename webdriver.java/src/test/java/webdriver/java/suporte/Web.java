package webdriver.java.suporte;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {

    public static final String USERNAME = "vitorcalado1";
    public static final String AUTOMATE_KEY = "yyGXT3w8AexAPQNnmk9s";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {
        System.setProperty("webdriver.chrome.driver", "G:\\Path\\chromedriver.exe");
        final WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navegando para a pagina Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }

    public static WebDriver createBrowserstack() {
        final DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");
        caps.setCapability("name", "vitorcalado1's First Test");

        WebDriver navegador = null;

        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
        } catch (final MalformedURLException e) {
            System.out.println("Houve Problemas com a URL: " + e.getMessage());
        }

        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navegando para a pagina Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");        
        return navegador;
    }
}