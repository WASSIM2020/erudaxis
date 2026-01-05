
@tag
Feature: connexion réussie sur Erudaxis staging
  

  @tag1
  Scenario: Connexion avec des identifiants valides
    Given j'accède à la page de connexion
    When je saisis un email valide "ghanmi.wassim58@gmail.com" et un mot de passe valide "Wassim@123!" et je clique sur se connecter
    Then je suis connecté avec succès

 