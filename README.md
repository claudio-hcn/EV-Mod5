# 🧪 EV-Mod5 - Automatización de Pruebas con Cucumber y Selenium

## 📌 Descripción

Este proyecto automatiza pruebas de inicio de sesión en una aplicación web utilizando **Cucumber** y **Selenium WebDriver**.  
Se implementan prácticas avanzadas de **BDD (Behavior Driven Development)** como:

- Uso de **Hooks** para configurar acciones antes y después de los escenarios.
- Organización de pruebas mediante **Tags** para filtrar y ejecutar casos específicos.
- Pruebas parametrizadas con **Scenario Outlines** para validar múltiples combinaciones de datos en un solo escenario.

La configuración de **Hooks**, **Tags** y **Scenario Outlines** refleja un alto nivel de conocimiento en prácticas de BDD.

## 🚀 Tecnologías Utilizadas

- Java 17
- Cucumber 7.14.0
- Selenium WebDriver
- JUnit
- Maven
- WebDriverManager

## 📝 Escenarios de Prueba

### Escenario de Inicio de Sesión Exitoso
```gherkin

@LoginSingle
Scenario: Inicio de sesión exitoso
  Given que el usuario abre la página de login
  When ingresa el correo "tomsmith"
  And la contraseña "SuperSecretPassword!"
  And hace clic en el botón de iniciar sesión
  Then debería ver el mensaje "You logged into a secure area!"


### Escenarios de Inicio de Sesión con Credenciales Inválidas (Scenario Outline)

@LoginOutline
Scenario Outline: Intentos de inicio de sesión con diferentes credenciales
  Given que el usuario abre la página de login
  When ingresa el correo "<usuario>"
  And la contraseña "<password>"
  And hace clic en el botón de iniciar sesión
  Then debería ver el mensaje "<mensajeEsperado>"

Examples:
  | usuario    | password             | mensajeEsperado                 |
  | tomsmith   | SuperSecretPassword! | You logged into a secure area!  |
  | tomsmith   | incorrecta           | Your password is invalid!       |
  | usuarioX   | SuperSecretPassword! | Your username is invalid!       |
  |            |                      | Your username is invalid!       |
  | tomsmith   |                      | Your password is invalid!       |
  |            | SuperSecretPassword! | Your username is invalid!       |
```

--- 

## 🛠️ Requisitos

- Java 17  
- Maven  
- Navegador Chrome (compatible con ChromeDriver gestionado por WebDriverManager)  

## 📥 Instalación y Ejecución

**Clonar el repositorio:**  
  `git clone https://github.com/LilianaCedeno/EV-Mod5.git`  

**Entrar al proyecto**  
  `cd EV-Mod5`

**Ejecutar pruebas**  
  `mvn clean test`


## 📸 Reportes y Evidencias  

  Las capturas de pantalla se adjuntan automáticamente a los reportes en caso de fallos gracias a la configuración de Hooks.  
  Los reportes generados permiten visualizar los resultados con detalles completos y evidencia visual.

## 📄 Licencia  

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más información.

## 👥 Autores

|       Nombre     | GitHub                 |
|:---------------:|:---------------------: |
| Samuel Millelche| [@Millelche](https://github.com/Millelche) |
| Claudio Carrasco| [@claudio-hcn](https://github.com/claudio-hcn) |
| Lili Cedeño     | [@LilianaCedeno](https://github.com/LilianaCedeno) |
