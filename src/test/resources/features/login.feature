@Login @HU-001
Feature: Inicio de sesión en la aplicación
  Como usuario registrado
  Quiero iniciar sesión
  Para acceder a mi panel personal

  @LoginOutline @HU-001
  Scenario Outline: Intentos de inicio de sesión con diferentes credenciales
    Given que el usuario abre la página de login
    When ingresa el correo "<usuario>"
    And la contraseña "<password>"
    And hace clic en el botón de iniciar sesión
    Then debería ver el mensaje "<mensajeEsperado>"

    Examples:
      | usuario    | password             | mensajeEsperado               |
      | tomsmith   | SuperSecretPassword! | You logged into a secure area!|
      | tomsmith   | incorrecta           | Your password is invalid!     |
      | usuarioX   | SuperSecretPassword! | Your username is invalid!     |
      |            |                      | Your username is invalid!     |
      | tomsmith   |                      | Your password is invalid!     |
      |            | SuperSecretPassword! | Your username is invalid!     |

  @LoginSingle @HU-001
  Scenario: Inicio de sesión exitoso
    Given que el usuario abre la página de login
    When ingresa el correo "tomsmith"
    And la contraseña "SuperSecretPassword!"
    And hace clic en el botón de iniciar sesión
    Then debería ver el mensaje "You logged into a secure area!"

  @LoginSingle @HU-001
  Scenario: Inicio de sesión fallido por usuario inválido
    Given que el usuario abre la página de login
    When ingresa el correo "usuarioX"
    And la contraseña "SuperSecretPassword!"
    And hace clic en el botón de iniciar sesión
    Then debería ver el mensaje "Your username is invalid!"
