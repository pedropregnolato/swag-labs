Feature: Testes de login no site Swag Labs [https://www.saucedemo.com/v1/]

  Scenario: Validar login com dados válidos
    Given que o usuário acessa a Login Page
    When insere o username "standard_user"
    And insere a password "secret_sauce"
    And clica no botão Login
    Then ele deve ver o título "Products"

  Scenario: Validar login com dados inválidos
    Given que o usuário acessa a Login Page
    When insere o username "incorrect_user"
    And And insere a password "incorrect_password"
    And clica no botão Login
    Then ele deve ver a mensagem de erro "Epic sadface: " "Username and password do not match any user in this service"

  Scenario: Validar login com username inválido
    Given que o usuário acessa a Login Page
    When insere o username "incorrect_user"
    And clica no botão Login
    Then ele deve ver a mensagem de erro "Epic sadface: " "Password is required"

  Scenario: Validar login sem preencher nenhum campo
    Given que o usuário acessa a Login Page
    When clica no botão Login
    Then ele deve ver a mensagem de erro "Epic sadface: " "Username is required"

  Scenario: Validar logout
    Given que o usuário acessa a Login Page
    When insere o username "standard_user"
    And insere a password "secret_sauce"
    And clica no botão Login
    And ele ve o título "Products"
    And clica no botão menu
    And clica no botão Logout
    Then ele deve voltar para Login Page