package com.saucedemo.v1.index.pages;

import com.saucedemo.v1.index.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// herdei o construtor BasePage
public class LoginPage extends BasePage {

    // implementei o construtor - agora tenho o driver aqui para usar
    // sempre que eu instanciar ele numa classe executora eu preciso
    // instanciar como objeto e com o construtor herdado
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void acessarPaginaLogin(String url) {
        driver.get(url);
    }

    public void campoUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    public void campoPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clicarBotaoLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    public void mensagemErro(String messageUm, String messageDois) {
        driver.findElement(By.xpath("//h3[text()[contains(., '"+messageUm+"')] and text()[contains(., '"+messageDois+"')]]")).getText();
    }




}
