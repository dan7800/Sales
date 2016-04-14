package com.krutzcorp.sales;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;
import java.util.Map;

/** An endpoint class we are exposing */
@Api(name = "salesApi",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "sales.krutzcorp.com",
                ownerName = "sales.krutzcorp.com",
                packagePath=""))

public class SalesAPI {
    @ApiMethod(name = "makeTransaction")
    public TransactionBean makeTransaction(@Named("user") String user, Map<String, String> soldItems) {
        TransactionBean response = new TransactionBean();
        response.setUser(user);
        response.setSoldItems(soldItems);

        return response;
    }

    @ApiMethod(name = "activeTransactions")
    public UserBean activeTransactions(@Named("user") String user) {
        UserBean response = new UserBean();
        response.setUser(user);

        return response;
    }

    @ApiMethod(name = "processRefund")
    public RefundBean processRefund(@Named("ticketId") String ticketId) {
        RefundBean response = new RefundBean();
        response.setTicketId(ticketId);

        return response;
    }
}