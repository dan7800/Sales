package com.krutzcorp.sales;

public class Product {

    private int product_amount;
    private int product_production_cost;
    private int product_cost;

    public Product(int product_id) {
        product_amount = getProductAmt(product_id);
        product_production_cost = getCostToMakePhone(product_id);
        product_cost = getProductCost(product_id);
    }

    private int getProductCost(int product_id) {
        //Contact Inventory API to request product cost via product id
        return 200;
    }

    private int getCostToMakePhone(int product_id) {
        //Contact Inventory API to request production cost via product id
        return 100;
    }

    private int getProductAmt(int product_id) {
        //Contact Inventory API to request product amount via product id
        return 300;
    }

    public int getProductAmount() {
        return product_amount;
    }

    public int getProductionCost() {
        return product_production_cost;
    }

    public int getProductCost() {
        return product_cost;
    }

    public void takeProducts(int productsToTake) {
        //Contact Inventory API to report products that are purchased (This would normally be done on their end.)
        product_amount = product_amount - productsToTake;
    }
}
