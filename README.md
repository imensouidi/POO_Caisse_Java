# Gestion de Restaurant - Application Java POO

## Description
Cette application est développée en Java en utilisant le paradigme de la programmation orientée objet (POO). Elle permet de gérer un restaurant en offrant des fonctionnalités de gestion des plats, des commandes et du suivi des ventes.

## Fonctionnalités Clés
- **Gestion des plats** :
  - Ajout, modification et affichage des plats (Entrée, Suite, Dessert)
  - Recherche de plats par code

- **Gestion des commandes** :
  - Création et suivi des commandes
  - Clôture des commandes
  - Affichage des détails d’une commande

- **Statistiques et gestion financière** :
  - Calcul de la recette journalière
  - Calcul du chiffre d'affaires sur une période donnée
  - Identification du plat le plus commandé

## Environnement de Développement
- **IDE Recommandé** : Cette application peut être développée et exécutée sur des environnements de développement intégrés (IDE) tels que **Eclipse**, **IntelliJ IDEA** ou **NetBeans** pour faciliter l'écriture, le débogage et l'exécution du code.

## Axes d'Amélioration
- **Interface Graphique** : Ajouter une interface utilisateur graphique (Swing, JavaFX) pour une meilleure expérience utilisateur.
- **Base de Données** : Intégrer une base de données (MySQL, SQLite) pour stocker les informations des plats et des commandes.
- **Gestion des Utilisateurs** : Ajouter un système de rôles (administrateur, serveur) avec authentification.
- **Tests Unitaires** : Ajouter des tests unitaires pour garantir la fiabilité des fonctionnalités.

## Installation et Exécution
1. **Cloner le projet**  
   ```sh
   git clone https://github.com/utilisateur/gestion-restaurant.git
   cd gestion-restaurant
   ```

2. **Compiler le projet**  
   ```sh
   javac -d bin src/restaurant/*.java
   ```

3. **Exécuter l'application**  
   ```sh
   java -cp bin restaurant.RESTAU
   ```
