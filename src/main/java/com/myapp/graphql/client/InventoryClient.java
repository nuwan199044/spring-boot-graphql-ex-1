package com.myapp.graphql.client;

import com.myapp.graphql.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InventoryClient {

    private final HttpGraphQlClient graphQlClient;

    public List<ItemDTO> viewProducts() {
        String graphQLQuery = "query GetProducts {\n" +
                "    getProducts {\n" +
                "        name\n" +
                "        category\n" +
                "        price\n" +
                "        stock\n" +
                "    }\n" +
                "}";

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProducts")
                .toEntityList(ItemDTO.class).block();
    }

    public List<ItemDTO> viewProductsByCategory(String category) {
        String graphQLQuery = String.format("query GetProductsByCategory {\n" +
                "    getProductsByCategory(category: %s) {\n" +
                "        name\n" +
                "        category\n" +
                "        stock\n" +
                "    }\n" +
                "}", category);

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProductsByCategory")
                .toEntityList(ItemDTO.class).block();
    }

    public ItemDTO receivedNewShipment(int id, int quantity) {
        String graphQLQuery = String.format("mutation ReceivedNewShipment {\n" +
                "    receivedNewShipment(id: \"%s\", quantity: %d) {\n" +
                "        name\n" +
                "        category\n" +
                "        stock\n" +
                "    }\n" +
                "}", id, quantity);
        return graphQlClient.document(graphQLQuery)
                .retrieve("receivedNewShipment")
                .toEntity(ItemDTO.class).block();
    }

}
