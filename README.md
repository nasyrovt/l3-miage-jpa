# TP JPA

Vous avez deux scéance de TP pour en venir à bout, vous être libre de continuer chez vous.

## Pre requis

* java 11+
* maven 3.6+
* docker (optionel) une base de données locale
* Accès Oracle (optionel) si vous souhaitez utiliser ce que vous connaissez et visualiser vos données

# Le modèle

Voici le modèle de données.

![model](https://raw.githubusercontent.com/bordigoni/l3-miage-jpa/main/assets/images/model.png)

⚠️Dans ce modèle il manque des informations importantes
1. Il ne peut y avoir qu'**une** promotion ayant un nom donné par an.
2. Le nom d'une matière est unique
3. Les attributs en gras sont obligatoires
4. Vous noterez que chaque relation a une cardinalité.

   Certaines relations sont uni-directionnelles et d'autre non.

   Vous devrez en tenir compte dans votre mapping et dans vos tests.

**Le modèle est déjà codé sous forme de classes Java.**

## A faire

Le but est de :

1. Mapper les classes sur la base, grâce aux annotations JPA
1. Coder puis tester les DAO avec JUnit sur base de données en mémoire (H2).

### le mapping
1. Cloner ou télécharger ce projet : `git clone https://github.com/bordigoni/l3-miage-jpa.git`
   * Pour ceux sont à l'aise avec github et ont un compte, vous pouvez forker et me donner accès à votre repository pour le rendu.
2. Dans un terminal, à la racine projet, lancez la commande `mvn clean install -DskipTests`
3. Importer le projet dans Eclipse "Import Maven Project"
4. Prenez le temps de regarder les classes et le test existant pour comprendre comment faire l'implémentation. Toutes les méthodes à implémenter sont présentes mais vides.
5. Annoter les classes pour faire le mapping
   * Les classes sont déjà déclarées dans `persistence.xml`
   * Vous être libre dans le choix de la stratégie pour mapper les héritages.
   * Conseil : commentez les relations si besoin et les ajouter de nouveau une à une en les annotant avec `@OneToMany`, `@ManyToOne` etc. afin qu'elles deviennent persistantes.
6. Implementer `save()` and `findById()` dans `SubjectRepositoryImpl`
7. Exécuter `SubjectTest` (partiellement codé), le test devrait passer si le mapping fonctionne.
  * ⚠️ certaines erreurs dans le mapping ne feront pas nécessairement planter votre test, vérifier les logs, il ne doit plus y avoir d'erreur.

### Repository et tests
Une fois votre mapping fait vous passez à l'implémentation des Repository (aussi connu sous le nom de DAO)

1. Implémeter un repository
  * Implementer une classe `*RepositoryImpl`
  * Implementer les tests du Repository (une méthode de test par méthode de Repository).
    Quelques conseils:
    1. Commitez la transaction pour executer les requêtes en base
    2. Pensez à appeler `entityManager.detach(...)` pour retirer les entités avant de les charger de nouveau
    3. Effectuer des assertions simples, mais suffisantes pour valider les opérations.
* Utiliser la classe `Fixtures` pour créer des objets prêts à devenir persistant, les données qu'ils contiennent sont généré aléatoirement.
* Sur l'ensemble de vos méthodes de test, vous devez appeler toutes les méthodes de votre repository.
* Vous devez optionnellement tester les mises à jour
2. Recommencez pour chaque Repository

Good luck! 🍀

Pour les élèves en avance ou souhaitant aller plus loin, si tous les tests passent, vous pouvez ajouter une classe `Address` que vous utiliserez dans `Person` qui pourra être mappé comme une entité "embedded". Vous pouvez également faire de nouvelles requêtes comme avoir la liste des dix meilleurs étudiants ou encore de récupérer la liste des enseignants qui enseigne plus d'une matière. Vous pouvez également optimiser certains rechercher en ajouter des index.

## Rendu

* Zipper le répertoire `src` et ne nommer `l3-miage-jpa-prenom1-nom1-prenom2-nom2.zip`
* Déposer sur le moodle.
* Si vous souhaitez ajouter des commentaires, merci de le faire dans ce README (sections commentaires) et du coup de le joindre au zip.

En replaçant le répertoire `src` du projet original par le vôtre le projet doit compiler et les tests passer.
C'est-à-dire que vous ne devez pas ajouter de dépendances dans `pom.xml`, vous êtes en revanche libres d'ajouter des classes, mais ça ne devrait pas être nécessaire.

Dicton : "Mieux vaut une implémentation partielle, mais bien testé qu'une implémentation complète, peu ou mal testé, car il sera difficile d'évaluer sa qualité."

## Commentaires de l'étudiant

Section optionelle si vous souhaitez justifier certains choix dans votre implémentation. Joindre le README au zip rendu le cas échéant.
