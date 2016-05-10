package com.krutzcorp.sales.models;

import java.util.ArrayList;

//Refund object used to carry out the refund process. It is started when Customer Service
//initiates it by hitting the /processRefund endpoint with a ticketID. This class is then
//supposed to hit Customer Support for a list of the phone's serial numbers, and then
//hit Accounting to report the refund. It will then return accounting's transaction ID
//and use that to determine if the refund was successful, outputting a message depending
//on the results.
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

    public long reportRefund() {
        //Contact Accounting API to report refund
        return 20;
    }

    public long getTransactionId() {
        return transactionId;
    }
}