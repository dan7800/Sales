package com.krutzcorp.sales;

import java.util.Map;

public class TransactionBean {
    private String user;
    Map<String, String> soldItems;

    public String getUser() {
        return user;
    }

    public void setUser(String data) {
        user = data;
    }

    public Map<String, String> getSoldItems() {
        soldItems.remove("user");
        soldItems.remove("alt");
        return soldItems;
    }

    public void setSoldItems(Map<String, String> itemList) {
        soldItems = itemList;
    }
}
