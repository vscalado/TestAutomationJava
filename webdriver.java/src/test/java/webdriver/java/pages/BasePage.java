package webdriver.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(final WebDriver navegador) {
        this.navegador = navegador;
    }
    
    public String captureToastText(){
        return navegador.findElement(By.id("toast-container")).getText();
    }
}