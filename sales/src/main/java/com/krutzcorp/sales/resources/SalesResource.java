package com.krutzcorp.sales.resources;

import com.krutzcorp.sales.models.Invoice;
import com.krutzcorp.sales.models.MakeSaleRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/makeTransaction")
@Consumes(MediaType.APPLICATION_JSON)
public class SalesResource {
    @POST
    public int post(MakeSaleRequest msRequest) {
        //User obtained by querying API
        Invoice invoice = new Invoice(msRequest.getUserId(), msRequest.getProduct_id(), msRequest.getQuantity());
        return invoice.getSalePrice();
    }
}