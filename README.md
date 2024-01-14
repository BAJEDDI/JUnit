# Démo JUnit avec Spring Boot

Ce projet de démonstration met en œuvre des tests unitaires avec JUnit dans le contexte d'une application Spring Boot. Le scénario de test concerne la manipulation d'entités Employee avec un repository associé.

## Qu'est-ce que JUnit?

JUnit est un framework de test unitaire pour le langage de programmation Java. Il fournit des annotations pour identifier les méthodes de test, des assertions pour vérifier les résultats attendus, et d'autres fonctionnalités pour faciliter le développement de tests unitaires fiables.

## Annotations utilisées

- @TestMethodOrder(MethodOrderer.OrderAnnotation.class): Spécifie l'ordre d'exécution des méthodes de test en utilisant MethodOrderer.OrderAnnotation.class, ordonnant les tests en fonction de l'annotation @Order.

- @RunWith(SpringRunner.class): Établit un lien entre JUnit et le cadre Spring TestContext, permettant l'utilisation du cadre de contexte de test Spring dans les tests JUnit.

- @SpringBootTest: Indique que la classe est un test Spring Boot. Charge le contexte d'application Spring complet et peut être utilisée pour tester les composants Spring.

- @Autowired: Injecte automatiquement une dépendance, dans ce cas, une instance de EmployeeRepository.

- @Test: Indique une méthode de test. Les méthodes annotées avec @Test seront exécutées en tant que tests par JUnit.

- @Order(n): Spécifie l'ordre d'exécution des méthodes de test annotées. Les méthodes sont exécutées dans l'ordre croissant de la valeur d'ordre assignée (n).

- @Rollback(value = false): Contrôle si une transaction doit être annulée après le test. Dans ce cas, défini sur false, ce qui signifie que les modifications apportées pendant le test seront validées.

## Fonctionnalités JUnit

- *Facilité de création de tests unitaires*: JUnit simplifie la création de tests unitaires en utilisant des annotations pour identifier les méthodes de test.

- *Assertions puissantes*: JUnit propose un ensemble complet d'assertions pour vérifier que les résultats attendus sont obtenus pendant l'exécution des tests.

- *Organisation des tests*: L'annotation @TestMethodOrder permet de spécifier l'ordre d'exécution des tests, assurant une organisation cohérente des scénarios de test.

- *Intégration avec Spring Boot*: Les annotations @RunWith(SpringRunner.class) et @SpringBootTest facilitent l'intégration des tests avec le framework Spring Boot.

- *Injection de dépendances automatique*: L'annotation @Autowired permet l'injection automatique de dépendances, améliorant la flexibilité des tests.

- *Contrôle des transactions avec @Rollback*: Vous pouvez contrôler le comportement des transactions après chaque test en utilisant l'annotation @Rollback.

## Méthodes de test

### saveEmployeeTest

- Crée une instance d'Employee.
- Sauvegarde avec employeeRepository.save().
- Vérifie que l'ID de l'employé est supérieur à 0.

### getEmployeeTest

- Récupère un employé par e-mail depuis le dépôt.
- Effectue des vérifications sur l'employé récupéré.

### getListOfEmployeesTest

- Récupère une liste de tous les employés depuis le dépôt.
- Vérifie que la taille de la liste est supérieure à 0.
- Imprime les détails de chaque employé dans la console.

### updateEmployeeTest

- Met à jour l'e-mail d'un employé.
- Sauvegarde les modifications.
- Vérifie que l'e-mail mis à jour correspond à la valeur attendue.

### deleteEmployeeTest

- Supprime un employé du dépôt.
- Vérifie que l'employé est désormais nul.

  
## Démonstration


https://github.com/BAJEDDI/JUnit/assets/147507670/8ad3891b-df73-4027-9c09-fb20de680737

