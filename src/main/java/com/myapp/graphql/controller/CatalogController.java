package com.myapp.graphql.controller;

import com.myapp.graphql.dto.ItemDTO;
import com.myapp.graphql.dto.ShipmentDTO;
import com.myapp.graphql.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/products")
    public List<ItemDTO> viewProducts() {
        return catalogService.viewProducts();
    }

    @GetMapping("/products/{category}")
    public List<ItemDTO> viewProductsByCategory(@PathVariable String category) {
        return catalogService.viewProductsByCategory(category);
    }

    @PostMapping("/shipment")
    public ItemDTO receivedNewShipment(@RequestBody ShipmentDTO shipmentDTO) {
        return catalogService.receivedNewShipment(shipmentDTO);
    }
}
