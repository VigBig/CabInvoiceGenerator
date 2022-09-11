package com.bridgelabz.cabinvoicegenerator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void testCalculateFareFor2KilometersAnd5Minutes() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals("Calculate Fare passed", 25, fare, 0.0);
    }

    @Test
    public void testCalculateFareFor100MetersAnd1Minute(){
        CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        double distance=0.1;
        int time=1;
        double fare=cabInvoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals("Calculate Fare passed",5,fare,0.0);
    }

//    @Test
//    public void testCalculateFareForMultipleRides(){
//        CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
//        Ride[] rides={new Ride(2.0,5),
//                new Ride(0.1,1)
//        };
//        double fare=cabInvoiceGenerator.calculateFare(rides);
//        Assert.assertEquals("fare",30,fare,0.0);
//    }

    @Test
    public void testCalculateFareForMultipleRidesShouldReturnInvoiceSummary(){
        Ride[] rides={new Ride(2.0,5),
                new Ride(0.1,1)
        };
        CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        InvoiceSummary invoiceSummary=cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expected_invoiceSummary=new InvoiceSummary(2,30.0);
        Assert.assertEquals(expected_invoiceSummary,invoiceSummary);
    }

}