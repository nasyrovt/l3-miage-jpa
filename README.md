# TP JPA

## Pre requis

* java 11+
* maven 3.6+
* docker (optionel)

# Le modèle

Voici le modèle de donnée.

![model](https://user-images.githubusercontent.com/12293102/150217615-569407fd-3b8a-45b6-9d2e-fbf965ab8e98.png)


Vous noterez que chaque relation a une cardinalité. Que certaines relations sont uni directionnelles et d'autre non.

**Vous n'avez pas à coder le modèle sous forme de classes Java, c'est déjà fait** 

## A faire

Le but est de mapper les classes sur la base et de tester des DAO avec JUnit sur base en mémoire.

### le mapping
* Cloner ce projet : `git clone https://github.com/bordigoni/l3-miage-jpa.git`
* Prenez le temps de regarder les classes et le test existant pour comprendre comment faire l'implémentation. Toutes les méthodes à implémenté sont présentes mais vides. 
* Annoter les classes pour faire le mapping 
  * Les classes sont déjà dans `persistence.xml`
  * Conseil : retirer les relations en commentant si besoin et les ajouter de nouveau une à la fois et les annoter pour qu'elles deviennent persistantes. 
* Implementer `save()` and `findById()` dans `SubjectRepositoryImpl`
* Exécuter `SubjectTest`, le teste devrait passer si le mapping fonctionne
  * Attention ! Une erreur dans le mapping ne fera pas nécessairement planter votre test, vérifier les logs, il ne doit pas plus y avoir d'erreur.

### Repository et tests
* Implementer les classes `*RepositoryImpl`
* Implementer le test de chaque Repository
* Utiliser la classe `Fixtures` pour créer des objets prêts à être persistés.

Good luck! 🍀

## Rendu

* Zipper le répertoire `src` au format `jpa-prenom1-nom1-prenom2-nom2.zip`
* Déposer sur le moodle.

En replaçant le répertoire src le projet original par le vôtre le projet doit compiler et les tests passer. 
C'est-à-dire que vous ne devez pas ajouter de dépendances dans `pom.xml` vous être en revanche libres d'ajouter ses classes, mais ça ne devrait pas être nécessaire.

Mieux vaut une implémentation partielle, mais bien testé qu'une implémentation complète, peu ou mal testé, car il sera difficile d'évaluer sa qualité. 
