# Product GraphQL Test Project

This is a **test project** for experimenting with **GraphQL** in a Spring Boot application. It demonstrates basic **queries, mutations, and testing** using Spring GraphQL.

---

## Features

* **GraphQL Queries**

  * `getProducts`: Retrieve all products.
  * `getProductsByCategory(category: String)`: Retrieve products filtered by category.

* **GraphQL Mutations**

  * `updateProduct(id: ID, stock: Int)`: Update the stock of a product.
  * `receiveNewShipment(id: ID, quantity: Int)`: Increase stock when receiving a shipment.

* **Testing**

  * Uses `GraphQlTester` to test queries and mutations.
  * Supports both database-backed and mocked service tests.
  * Example tests for:

    * Querying all products.
    * Querying products by category.
    * Updating product stock.
    * Receiving new shipment.

---

## Technologies Used

* Java 17+
* Spring Boot 3.x
* Spring GraphQL
* JPA / Hibernate
* H2 in-memory database (for testing)
* Mockito (for mocking services)
* JUnit 5

---

## Getting Started

### Clone the project

```bash
git clone <your-repo-url>
cd <project-directory>
```

### Build and run

```bash
./mvnw spring-boot:run
```

The GraphQL endpoint will be available at:

```
POST http://localhost:8080/graphql
```

---

### Example GraphQL Queries

**Get all products**

```graphql
query {
  getProducts {
    id
    name
    category
    price
    stock
  }
}
```

**Get products by category**

```graphql
query {
  getProductsByCategory(category: "Electronics") {
    id
    name
    price
  }
}
```

---

### Example GraphQL Mutations

**Update product stock**

```graphql
mutation {
  updateProduct(id: "1", stock: 50) {
    id
    stock
  }
}
```

**Receive new shipment**

```graphql
mutation {
  receiveNewShipment(id: "1", quantity: 10) {
    id
    stock
  }
}
```

---

## Running Tests

Run tests using Maven:

```bash
./mvnw test
```

* Tests use `GraphQlTester` to verify queries and mutations.
* Supports both **mocked service tests** and **integration tests** with in-memory database.

---

## Notes

* This is a **learning/test project**, intended for experimenting with Spring GraphQL.
* All test data is either **mocked** or stored in an **H2 in-memory database**, making it safe to experiment without affecting production data.

---

## License

This project is open-source and free to use for learning and experimentation purposes.

