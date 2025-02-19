package com.saucedemo.v1.index.pages;

import com.saucedemo.v1.index.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage  extends BasePage {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void productsSelectionPage(String products) {
        String productsLabel = driver.findElement(By.className("product_label")).getText();
        Assertions.assertEquals("Products", productsLabel);
    }

    public void menuButton() {
        driver.findElement(By.className("bm-burger-button")).click();
    }


    public void logout() {

        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}
