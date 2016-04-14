package com.krutzcorp.sales;

import java.util.Map;

public class Invoice {

    private String user;
    private Map<Integer, Integer> saleItems;
    private int salePrice;
    private int invoiceId;

    public Invoice (String user, Map<Integer, Integer> saleItems, int salePrice, int costOfGoodsSold) {
        this.user = user;
        this.saleItems = saleItems;
        this.salePrice = salePrice;
        this.invoiceId = getInvoiceId(costOfGoodsSold, salePrice);
    }

    private int getInvoiceId(int costOfGoodsSold, int salePrice) {
        //Contact Accounting API to notify them of sale, receive invoice ID
        return 43583028;
    }

    public int getInvoice() {
        return invoiceId;
    }
}
