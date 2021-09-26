# CAS & Quarkus 

Projet de test ayant pour objectif de tester Quarkus & Qute Template dans un cas concret.  

## Fonctionnalités

Les fonctionnalités fixées par ce projet sont celle du CAS en [suivant les protocoles V2 et V3 CAS](https://apereo.github.io/cas/6.3.x/protocol/CAS-Protocol.html)

## Reste à faire
- [x] Connexion OK en protocole V2 & V3
- [] Vérification des services autorisés 
- [] Gestion des tickets (TGT, ST) dans la mémoire (par de délégation à Redis)
- [] Gestion du cookie CASTGC
- [] Gestion du JSESSIONID cookie
- [] SSO (basé sur les tickets & cookies précément créés)
- [] Récupération et envoi des attributs (serviceValidate & /p3/serviceValidate) via Qute Template

# Documentation Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/casandquarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
