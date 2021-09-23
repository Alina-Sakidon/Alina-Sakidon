package ua.hillel.tests.rest;

import APIStore.ApiException;
import APIStore.ApiStore;
import entity.PetOrder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;


public class ApiTestStore {
    @Test
    public void getStoreInventory() throws IOException, ApiException {
        ApiStore.getPetInventoriesByStatus();
    }
    @Test
    public void orderPetTests() throws IOException, ApiException {
        int orderId = 8;
        PetOrder petOrder = new PetOrder();
        petOrder.setId(orderId);
        petOrder.setPetId(7);
        petOrder.setQuantity(4);
        petOrder.setShipDate(LocalDateTime.now().toString());
        petOrder.setStatus("placed");
        petOrder.setComplete(true);

        Assert.assertEquals(ApiStore.placeOrder(petOrder).getId(), orderId);

        Assert.assertEquals(ApiStore.getOrderById(orderId).getId(), orderId);

        ApiStore.deleteOrderById(orderId);
    }
}
