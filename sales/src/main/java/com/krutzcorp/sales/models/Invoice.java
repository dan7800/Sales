package com.krutzcorp.sales.models;

//Invoice object used to carry out the transaction process. It is started when the Sales front end
//initiates it by hitting the /makeTransaction endpoint with a userId, product_id, and quantity. This class is then
//supposed to hit Inventory for the product sale price and cost to make, and finally
//hit Accounting to report the transaction. It will then return accounting's invoice ID
//and use that to determine if the transaction was successful, outputting a message depending
//on the results.
public class Invoice {

    private String user;
    private String productId;
    private int salePrice;
    private int costOfGoodsSold;
    private int invoiceId;
    private String quantity;

    public Invoice (String user, String product_id, String quantity) {
        this.user = user;
        this.quantity = quantity;
        this.productId = product_id;
        this.salePrice = calculateSalePrice(product_id, quantity);
        this.costOfGoodsSold = calculateCostofGoods(product_id, quantity);
        this.invoiceId = getInvoiceId(costOfGoodsSold, salePrice);
    }

    public int calculateCostofGoods(String product_id, String quantity) {
        //Contact Inventory API to get manufactoring price
        return 300 * Integer.valueOf(quantity);
    }

    public int calculateSalePrice(String product_id, String quantity) {
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

    public String getQuantity() {
        return quantity;
    }

    public int getInvoiceId(int costOfGoodsSold, int salePrice) {
        //Contact Accounting API to notify them of sale, receive invoice ID
        return 28;
    }

    public int getInvoice() {
        return invoiceId;
    }
}