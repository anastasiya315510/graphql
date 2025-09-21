package com.trufin.graphql;

import com.trufin.graphql.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
class ProductGraphQLTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void testGetProducts() {
        String query = """
            query {
              getProducts {
                id
                name
                category
                price
                stock
              }
            }
            """;

        graphQlTester.document(query)
                .execute()
                .path("getProducts")
                .entityList(Product.class)   // Maps directly to your Product class
                .hasSizeGreaterThan(0);
    }

    @Test
    void testGetProductsByCategory() {
        String query = """
            query {
              getProductsByCategory(category: "Electronics") {
                id
                name
              }
            }
            """;

        graphQlTester.document(query)
                .execute()
                .path("getProductsByCategory[0].name")
                .entity(String.class)
                .isEqualTo("Laptop");
    }

    @Test
    void testUpdateProduct() {
        String mutation = """
            mutation {
              updateProduct(id: "1", stock: 50) {
                id
                stock
              }
            }
            """;

        graphQlTester.document(mutation)
                .execute()
                .path("updateProduct.stock")
                .entity(Integer.class)
                .isEqualTo(50);
    }

    @Test
    void testReceiveNewShipment() {
        String mutation = """
            mutation {
              receiveNewShipment(id: "1", quantity: 10) {
                id
                stock
              }
            }
            """;

        graphQlTester.document(mutation)
                .execute()
                .path("receiveNewShipment.stock")
                .entity(Integer.class)
                .satisfies(stock -> {
                    assert stock >= 10; // basic assertion, customize as needed
                });
    }
}
