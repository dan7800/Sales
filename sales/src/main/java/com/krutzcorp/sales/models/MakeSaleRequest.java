package com.krutzcorp.sales.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Just a basic POJO to represent the body of a request to the /customersupport endpoint.
 */
public class MakeSaleRequest {

    private String userId;
    private String quantity;
    private String product_id;

    public MakeSaleRequest(@JsonProperty("userId") String userId,
                           @JsonProperty("product_id") String product_id,
                           @JsonProperty("quantity") String quantity) {
        this.userId = userId;
        this.quantity = quantity;
        this.product_id = product_id;

    }

    public String getUserId() {
        return userId;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("userId", userId)
                .toString();
    }
}