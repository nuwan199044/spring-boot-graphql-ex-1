package com.myapp.graphql.service;

import com.myapp.graphql.client.InventoryClient;
import com.myapp.graphql.dto.ItemDTO;
import com.myapp.graphql.dto.ShipmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final InventoryClient inventoryClient;

    public List<ItemDTO> viewProducts() {
        return inventoryClient.viewProducts();
    }

    public List<ItemDTO> viewProductsByCategory(String category) {
        return inventoryClient.viewProductsByCategory(category);
    }

    public ItemDTO receivedNewShipment(ShipmentDTO shipmentDTO) {
        return inventoryClient.receivedNewShipment(shipmentDTO.getId(), shipmentDTO.getQuantity());
    }
}
