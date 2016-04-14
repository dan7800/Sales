package com.krutzcorp.sales;

public class RefundBean {
    private String ticketId;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String data) {
        ticketId = data + " Refund was successful!";
    }
}
