package webdriver.java.suporte;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    public static void tirar(final WebDriver navegador, final String arquivo) {
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(arquivo));
        }catch (final Exception e) {
            System.out.println("Houveram Problemas ao Copiar o Arquivo para a pasta" + e.getMessage());
        }
    }
}