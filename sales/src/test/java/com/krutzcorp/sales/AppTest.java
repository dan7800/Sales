package com.krutzcorp.sales;

import com.krutzcorp.sales.models.CSRequest;
import com.krutzcorp.sales.models.Invoice;
import com.krutzcorp.sales.models.MakeSaleRequest;
import com.krutzcorp.sales.models.Refund;
import com.krutzcorp.sales.resources.CSResource;
import com.krutzcorp.sales.resources.SalesResource;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testInvoiceUser() {
        Invoice newInvoice = new Invoice("1", "2", "2");
        assertEquals("1", newInvoice.getUser());
    }

    public void testInvoiceProductId() {
        Invoice newInvoice = new Invoice("1", "2", "2");
        assertEquals("2", newInvoice.getProductId());
    }

    public void testInvoiceQuantity() {
        Invoice newInvoice = new Invoice("1", "2", "2");
        assertEquals("2", newInvoice.getQuantity());
    }

    public void testInvoiceSalePrice() {
        Invoice newInvoice = new Invoice("1", "2", "2");
        assertEquals(800, newInvoice.getSalePrice());
    }

    public void testInvoiceCostOfGoods() {
        Invoice newInvoice = new Invoice("1", "2", "2");
        assertEquals(600, newInvoice.calculateCostofGoods("2", "2"));
    }

    public void testInvoiceId() {
        Invoice newInvoice = new Invoice("1", "2", "2");
        assertEquals(28, newInvoice.getInvoiceId(600, 2));
    }

    public void testRefundTicketId() {
        Refund refund = new Refund("1", 0, 0);
        assertEquals("1", refund.getTicketId());
    }

    public void testRefundValue() {
        Refund refund = new Refund("1", 0, 0);
        assertEquals(0, refund.getRefundValue());
    }

    public void testRefundAmount() {
        Refund refund = new Refund("1", 0, 0);
        assertEquals(0, refund.getRefundAmount());
    }

    public void testTransactionAPI() {
        MakeSaleRequest msRequest = new MakeSaleRequest("1", "2", "2");
        SalesResource sales = new SalesResource();
        String message = sales.post(msRequest);
        assertEquals("Sale Success!", message);
    }

    public void testRefundAPI() {
        CSRequest csRequest = new CSRequest("20");
        CSResource csResource = new CSResource();
        String message = csResource.post(csRequest);
        assertEquals("Refund Success!", message);

    }
}
