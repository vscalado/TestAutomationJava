package webdriver.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {

    public AddContactPage(WebDriver navegador) {
        super(navegador);
    }

    public AddContactPage searchContactType(String tipo){
        final WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        return this;
    }
    public AddContactPage typeContact(String contato) {
        navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

        return this;
    }

    public MePage clickSave() {
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new MePage(navegador);
    }

    public MePage addContact(String tipo, String contato){
        searchContactType(tipo);
        typeContact(contato);
        clickSave();

        return new MePage(navegador);
    }
}
