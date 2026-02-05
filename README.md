# Calculatrice

Projet réalisé par:
- Dorian Weber
- Alaïs Deprez
- Benoit Champlon

Dans le cadre du cours "Introduction à la POO avec Java" de M. **Stephane Joyeux**.

**Sujet:**
## Objectif du projet

L’objectif de ce projet est de concevoir et développer une calculatrice simple en Java en appliquant rigoureusement les principes de la Programmation Orientée Objet, la gestion des exceptions et les tests unitaires.
Le projet se réalise en groupe de 3 personnes.

### Étape 0 – Conception (obligatoire)

Avant toute ligne de code :
#### Analysez le problème fonctionnel.
#### Identifiez les responsabilités principales de l’application.
#### Proposez un diagramme de classes UML comprenant au minimum :
- Les classes métier
- Leurs responsabilités
- Leurs relations (association, dépendance)

Le diagramme devra refléter une séparation claire des rôles.

### Étape 1 – Saisie de l’expression

Le programme doit permettre à l’utilisateur de saisir une expression mathématique simple sous la forme :
**Valeur1** **Opérateur** **Valeur2**

Exemples :
2 + 3
10 / 2
5 * 7

Contraintes :
- Les valeurs peuvent être entières ou décimales
- Les opérateurs autorisés sont : +, -, *, /

### Étape 2 – Analyse et validation de l’expression

Vous devez implémenter un composant chargé :
- D’analyser l’expression saisie
- De vérifier sa validité syntaxique et sémantique
La validation ne doit pas retourner simplement TRUE/FALSE.

**Gestion des erreurs attendue**
Les cas d’erreurs devront être gérés via des exceptions personnalisées, par exemple :
- Format incorrect
- Opérateur inconnu
- Division par zéro
- Valeur non numérique
Chaque erreur doit être identifiée clairement.

### Étape 3 – Calcul du résultat

Si l’expression est valide :
- Le calcul est effectué
- Le résultat est affiché à l’utilisateur

En cas d’erreur :
- Un message clair et compréhensible est affiché
- L’application ne doit jamais planter brutalement

### Étape 4 – Bonnes pratiques POO (exigées)

Le projet devra démontrer :
- Respect du principe de responsabilité unique (SRP)
- Encapsulation des données
- Usage pertinent des interfaces ou classes abstraites si nécessaire
- Absence de logique métier dans la classe Main
- Code lisible, structuré et commenté

### Étape 5 – Tests unitaires (obligatoires)

Vous devez écrire des tests unitaires avec JUnit couvrant au minimum :
- Les calculs corrects
- Les cas d’erreur
- Les opérateurs autorisés
- Les cas limites (division par zéro, valeurs invalides)
- Les tests doivent être :
    - Indépendants
    - Reproductibles
    - Compréhensibles

### Étape 6 – Extensions (optionnelles)

Selon l’avancement :
- Ajout de nouveaux opérateurs
- Historique des calculs (en mémoire)
- Amélioration de l’interface utilisateur

L’usage d’une base de données est facultatif et non prioritaire.


## Mode d'emploi

Créer une instance de la classe **Manager**, puis appeller la méthode **calculatrice**.

## Diagrammes

