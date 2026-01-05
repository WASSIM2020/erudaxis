

@tag_cantine
Feature: Gestion de la cantine - Ajout d'un repas

  Scenario: Ajout réussi d'un repas
    Given je suis connecté en tant qu'utilisateur avec l'email "ghanmiwassim58@gmail.com" et le mot de passe "Wassim@123!"
    When je navigue vers la page de gestion de la cantine "https://staging.erudaxis.com/cantine/gestion-cantine"
    And je clique sur le bouton "Ajouter un repas"
    And je remplis les champs suivants :
      | Nom du repas          | Pizza 4 saisons |
      | Description           | Pizzaa délicieuse |
      | Date                  | 25/12/2025              |
      | Catégorie             | Déjeuner                |
      | Prix                  | 8.50                    |
      | Quantité              | 1                 |
    And je clique sur "Créer"
    Then le repas est ajouté avec succès et visible dans la liste
