
@tag
Feature: Ajout d'un collaborateur
  

  @tag1
  Scenario: Affichage de la page d'ajout d'un collaborateur
    Given je suis authentifié 
    When je clique sur Administration puis Utilisateurs puis Collaboration puis sur l'icône Ajouter collaborateur
    Then la page ajouter un collaborateur s'affiche
    

  