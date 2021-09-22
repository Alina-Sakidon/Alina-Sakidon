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
        PetOrder petOrder = new PetOrder();
        petOrder.setId(8);
        petOrder.setPetId(7);
        petOrder.setQuantity(4);
        petOrder.setShipDate(LocalDateTime.now().toString());
        petOrder.setStatus("placed");
        petOrder.setComplete(true);

        Assert.assertEquals(petOrder.getId(),ApiStore.placeOrder(petOrder));

        ApiStore.getOrderById(petOrder.getId());

        ApiStore.deleteOrderById(petOrder.getId());
    }

}
