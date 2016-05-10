package com.krutzcorp.sales.models;

import java.util.ArrayList;

public class Refund {

    private String ticketId;
    private ArrayList<String> serialNums;
    private int refundAmount;
    private int refundValue;
    private long transactionId;

    public Refund (String ticketId, int refundAmount, int refundValue) {
        this.ticketId = ticketId;
        this.refundAmount = refundAmount;
        this.refundValue = refundValue;
        this.serialNums = getSerialNums(ticketId);
        this.transactionId = reportRefund();
    }

    private ArrayList<String> getSerialNums(String ticketId) {
        //Contact Customer Support API to obtain serial nums
        ArrayList<String> serialNums = new ArrayList<>();
        serialNums.add(0, "205803");
        return serialNums;
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public int getRefundValue() {
        return refundValue;
    }

    public String getTicketId() {
        return ticketId;
    }

    private long reportRefund() {
        //Contact Accounting API to report refund
        return 20;
    }

    public long getTransactionId() {
        return transactionId;
    }
}