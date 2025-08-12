package steps;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("que el usuario abre la página de login")
    public void abrirPaginaLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("ingresa el correo {string}")
    public void ingresarCorreo(String correo) {
        WebElement campoUsuario = driver.findElement(By.id("username"));
        campoUsuario.clear();
        // Solo enviar si no está vacío
        if (correo != null && !correo.trim().isEmpty()) {
            campoUsuario.sendKeys(correo);
        }
    }

    @When("la contraseña {string}")
    public void ingresarPassword(String password) {
        WebElement campoPassword = driver.findElement(By.id("password"));
        campoPassword.clear();
        // Solo enviar si no está vacío
        if (password != null && !password.trim().isEmpty()) {
            campoPassword.sendKeys(password);
        }
    }

    @When("hace clic en el botón de iniciar sesión")
    public void clicIniciarSesion() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("debería ver el mensaje {string}")
    public void validarMensaje(String mensajeEsperado) {
        String mensaje = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        ).getText();
        mensaje = mensaje.replace("×", "").trim();  // Limpia el cierre del mensaje
        System.out.println("Mensaje capturado: '" + mensaje + "'");
        assertTrue("El mensaje esperado no coincide. Esperado: '" + mensajeEsperado + "', recibido: '" + mensaje + "'",
            mensaje.contains(mensajeEsperado));
    }


}
