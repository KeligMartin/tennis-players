### Prérequis

+ Java 21
+ Maven 3.8.8
+ PostgreSQL 16

#### Installer le projet

```shell
mvn clean install
```

#### Lancer le projet
```shell
mvn spring-boot:run
```

#### Lancer les tests
```shell
mvn clean test
```


#### Routes à tester:

```http
GET http://localhost:8080/api/v1/players renvoie la liste des joueurs

GET http://localhost:8080/api/v1/players/52 renvoie les données de Novak Djokovic

GET http://localhost:8080/api/v1/players/1234 renvoie une erreur 404

GET http://localhost:8080/api/v1/stats renvoie les statistiques relatives aux entités
```
