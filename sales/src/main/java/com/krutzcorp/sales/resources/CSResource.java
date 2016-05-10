package com.krutzcorp.sales.resources;

import com.krutzcorp.sales.models.Refund;
import com.krutzcorp.sales.models.CSRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/processRefund")
@Consumes(MediaType.APPLICATION_JSON)
public class CSResource {
    @POST
    public String post(CSRequest csRequest) {
    	//Numbers obtained by querying Accounting API
    	Refund refund = new Refund(csRequest.getTicketId(), 0, 0);
    	if(refund.getTransactionId() == 20) {
        	return "Refund Successful\n";
        }
        return "Refund Failed";
    }
}