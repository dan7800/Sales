package com.krutzcorp.sales.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Represents the request to the /processRefund endpoint.
 */
public class CSRequest {

    private String ticketId;

    public CSRequest(@JsonProperty("ticketId") String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("ticketId", ticketId)
                .toString();
    }
}