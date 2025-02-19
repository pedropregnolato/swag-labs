package com.saucedemo.v1.index.steps;

import com.saucedemo.v1.index.BasePage;
import com.saucedemo.v1.index.pages.InventoryPage;
import com.saucedemo.v1.index.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginSteps {

    private final String url = "https://www.saucedemo.com/v1/index.html";
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;


    @Before
    public void setuUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

    }

    @Given("que o usuário acessa a Login Page")
    public void que_o_usuário_acessa_a_login_page() {

        loginPage.acessarPaginaLogin(url);

    }

    @When("insere o username {string}")
    public void insere_o_username(String username) {
        loginPage.campoUsername(username);
    }

    @When("insere a password {string}")
    public void insere_a_password(String password) {
        loginPage.campoPassword(password);
    }

    @When("clica no botão Login")
    public void clica_no_botão_login() {
        loginPage.clicarBotaoLogin();
    }

    @Then("ele deve ver o título {string}")
    public void ele_deve_ver_o_título(String titulo) {
        inventoryPage.productsSelectionPage("Products");
    }

    @When("And insere a password {string}")
    public void and_insere_a_password(String password) {
        loginPage.campoPassword(password);
    }

    @Then("ele deve ver a mensagem de erro {string} {string}")
    public void ele_deve_ver_a_mensagem_de_erro(String messageUm, String messageDois) {
        loginPage.mensagemErro(messageUm, messageDois);
    }

    @When("ele ve o título {string}")
    public void ele_ve_o_título(String titulo) {
        inventoryPage.productsSelectionPage("Products");
    }

    @When("clica no botão menu")
    public void clica_no_botão_menu() {
        inventoryPage.menuButton();
    }

    @When("clica no botão Logout")
    public void clica_no_botão_logout() {
        inventoryPage.logout();
    }

    @Then("ele deve voltar para Login Page")
    public void ele_deve_voltar_para_login_page() {
        String urlAtual = driver.getCurrentUrl();
        Assertions.assertEquals(url, urlAtual);
    }

    @After
    public void tearDown() {
        //fechar navegador
        if (driver != null) {
            driver.quit();
        }
    }


}
