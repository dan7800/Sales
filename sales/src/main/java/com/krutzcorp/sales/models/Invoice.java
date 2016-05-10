package com.krutzcorp.sales.models;

public class Invoice {

    private String user;
    private String productId;
    private int salePrice;
    private int costOfGoodsSold;
    private int invoiceId;

    public Invoice (String user, String product_id, String quantity) {
        this.user = user;
        this.productId = product_id;
        this.salePrice = calculateSalePrice(product_id, quantity);
        this.costOfGoodsSold = calculateCostofGoods(product_id, quantity);
        this.invoiceId = getInvoiceId(costOfGoodsSold, salePrice);
    }

    private int calculateCostofGoods(String product_id, String quantity) {
        //Contact Inventory API to get manufactoring price
        return 300 * Integer.valueOf(quantity);
    }

    private int calculateSalePrice(String product_id, String quantity) {
        //Contact Inventory API to get sale price
        return 400 * Integer.valueOf(quantity);
    }

    public int getSalePrice() {
        return salePrice;
    }

    public String getUser() {
        return user;
    }

    public String getProductId() {
        return productId;
    }

    private int getInvoiceId(int costOfGoodsSold, int salePrice) {
        //Contact Accounting API to notify them of sale, receive invoice ID
        return 43583028;
    }

    public int getInvoice() {
        return invoiceId;
    }
}