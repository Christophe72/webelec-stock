# Webelec Stock — API REST de gestion de stock

Application Spring Boot REST API pour la gestion de l'inventaire, des clients, des chantiers et des certifications VCA d'une entreprise électrique.

---

## Fonctionnalités

- **Produits** : gestion de l'inventaire de matériel électrique
- **Clients** : gestion des fiches clients
- **Chantiers** : suivi des projets d'installation électrique
- **VCA** : suivi des certifications de sécurité du personnel

---

## Technologies

| Technologie | Version |
|---|---|
| Java | 21 |
| Spring Boot | 3.5.13 |
| Spring Data JPA / Hibernate | — |
| PostgreSQL | — |
| Flyway (migrations BDD) | — |
| Lombok | — |
| Maven | — |

---

## Prérequis

- Java 21+
- PostgreSQL en cours d'exécution sur `localhost:5432`
- Maven (ou utiliser le wrapper `mvnw` inclus)

---

## Configuration

Le fichier de configuration est `src/main/resources/application.yaml`.

| Paramètre | Valeur par défaut |
|---|---|
| Port serveur | `8081` |
| Base de données | `webelec_stock` |
| Hôte PostgreSQL | `localhost:5432` |
| Identifiant | `postgres` |
| Mot de passe | `postgres` |

Modifiez ces valeurs selon votre environnement avant de lancer l'application.

---

## Installation et démarrage

**1. Créer la base de données PostgreSQL**

```sql
CREATE DATABASE webelec_stock;
```

**2. Construire le projet**

```bash
./mvnw clean package
```

**3. Lancer l'application**

```bash
./mvnw spring-boot:run
```

Ou via le JAR généré :

```bash
java -jar target/webelec-stock-0.0.1-SNAPSHOT.jar
```

**4. Accéder à l'API**

```
http://localhost:8081
```

> Au démarrage, Flyway exécute automatiquement les scripts de migration situés dans `src/main/resources/db/migration/`. Les tables sont créées et des données d'exemple sont insérées.

---

## Endpoints de l'API

### Produits — `/api/products`

| Méthode | URL | Description |
|---|---|---|
| GET | `/api/products` | Liste tous les produits |
| GET | `/api/products/{id}` | Récupère un produit par son ID |
| POST | `/api/products` | Crée un nouveau produit |
| DELETE | `/api/products/{id}` | Supprime un produit |

**Exemple de corps (POST) :**
```json
{
  "reference": "DIS-63A",
  "name": "Disjoncteur 63A",
  "quantity": 50,
  "price": 12.99
}
```

---

### Clients — `/api/customers`

| Méthode | URL | Description |
|---|---|---|
| GET | `/api/customers` | Liste tous les clients |
| GET | `/api/customers/{id}` | Récupère un client par son ID |
| POST | `/api/customers` | Crée un nouveau client |
| DELETE | `/api/customers/{id}` | Supprime un client |

**Exemple de corps (POST) :**
```json
{
  "firstName": "Jean",
  "lastName": "Dupont",
  "email": "jean.dupont@example.com",
  "phone": "0471234567"
}
```

---

### Chantiers — `/api/chantiers`

| Méthode | URL | Description |
|---|---|---|
| GET | `/api/chantiers` | Liste tous les chantiers |
| GET | `/api/chantiers/{id}` | Récupère un chantier par son ID |
| POST | `/api/chantiers` | Crée un nouveau chantier |
| DELETE | `/api/chantiers/{id}` | Supprime un chantier |

**Statuts disponibles :** `EN_COURS` · `TERMINE` · `EN_PAUSE` · `ANNULE`

**Exemple de corps (POST) :**
```json
{
  "name": "Rénovation électrique Rue de la Loi",
  "address": "Rue de la Loi 1, 1000 Bruxelles",
  "status": "EN_COURS",
  "startDate": "2026-01-15",
  "endDate": "2026-06-30"
}
```

---

### VCA (Certifications sécurité) — `/api/vca`

| Méthode | URL | Description |
|---|---|---|
| GET | `/api/vca` | Liste tous les dossiers VCA |
| GET | `/api/vca/{id}` | Récupère un dossier VCA par son ID |
| POST | `/api/vca` | Crée un nouveau dossier VCA |
| DELETE | `/api/vca/{id}` | Supprime un dossier VCA |

**Niveaux disponibles :** `VCA_BASIS` · `VCA_VOL` · `VCA_PETROCHIMIE`

**Statuts disponibles :** `EN_COURS` · `REUSSI` · `ECHOUE`

**Exemple de corps (POST) :**
```json
{
  "candidateName": "Pierre Martin",
  "company": "Webelec SA",
  "niveau": "VCA_VOL",
  "examDate": "2026-03-10",
  "examCenter": "Certiforce Liège",
  "score": 85,
  "status": "REUSSI",
  "certificateNumber": "VCA-2026-00123",
  "expiryDate": "2029-03-10"
}
```

---

## Structure du projet

```
webelec-stock/
├── pom.xml
├── mvnw / mvnw.cmd
└── src/
    ├── main/
    │   ├── java/com/webelec/stock/
    │   │   ├── WebelecStockApplication.java
    │   │   ├── product/          # Entité, contrôleur, service, repository, DTO
    │   │   ├── customer/
    │   │   ├── chantier/
    │   │   └── vca/
    │   └── resources/
    │       ├── application.yaml
    │       └── db/migration/     # Scripts Flyway (V1 à V9)
    └── test/
```

---

## Migrations de base de données (Flyway)

| Version | Description |
|---|---|
| V1 | Création de la table `product` |
| V2 | Données d'exemple — produits électriques |
| V3 | Création de la table `customer` |
| V4 | Données d'exemple — clients |
| V5 | Création de la table `chantier` |
| V6 | Données d'exemple — chantiers |
| V7 | Création de la table `vca` |
| V8 | Données d'exemple — certifications VCA |
| V9 | Correction du schéma `vca` + nouvelles données |

---

## Données d'exemple

L'application démarre avec des données préchargées :
- 8 produits électriques (disjoncteurs, prises, câbles, etc.)
- 5 clients avec coordonnées
- 5 chantiers dans différents états
- 5 dossiers de certification VCA

---

## Architecture

L'application suit une architecture en couches classique :

```
Requête HTTP
    └── Controller  (REST, validation des entrées)
         └── Service    (logique métier, @Transactional)
              └── Repository (Spring Data JPA)
                   └── PostgreSQL
```

Les entités JPA sont mappées aux tables SQL. Les DTO (Request) sont utilisés pour les entrées API avec validation Jakarta Validation (@NotBlank, @Email, @Min, etc.).
