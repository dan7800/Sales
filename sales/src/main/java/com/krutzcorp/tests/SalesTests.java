package com.krutzcorp.tests;

import com.krutzcorp.sales.Invoice;
import com.krutzcorp.sales.Refund;
import com.krutzcorp.sales.Product;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SalesTests {
    //Tests the API communications required to execute a refund.
    @Test
    public void testRefund() {
        Refund newRefund = new Refund("1", 9000, 6000);
        assertEquals(2058205823, newRefund.getTransactionId());
    }

    //Tests the API communications required to receive information on a product
    @Test
    public void testProduct() {
        Product newProduct = new Product(1);
        assertEquals(100, newProduct.getProductionCost());
        assertEquals(200, newProduct.getProductCost());
        assertEquals(300, newProduct.getProductAmount());
        newProduct.takeProducts(200);
        assertEquals(100, newProduct.getProductAmount());
    }

    //Tests the API communications required to create an invoice (sale)
    @Test
    public void testInvoice() {
        Map<Integer, Integer> saleItems = new HashMap<>();
        saleItems.put(1, 30);
        Invoice newInvoice = new Invoice("currentUser", saleItems, 9000, 6000);
        assertEquals(43583028, newInvoice.getInvoice());
    }
}