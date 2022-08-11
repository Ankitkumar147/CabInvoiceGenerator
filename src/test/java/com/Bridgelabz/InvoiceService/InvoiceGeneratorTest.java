package com.Bridgelabz.InvoiceService;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class InvoiceGeneratorTest {
    InvoiceGenerator i = null;
    RideRepository rideRepository = new RideRepository();
    HashMap<Integer, Ride[]>rideRepo;

    @Before
    public void initialization(){
        i = new InvoiceGenerator();
        rideRepo = rideRepository.getRideRepo();
    }

    @Test
    public void passTestForGivenDistanceAndTime() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 5;
        double time = 5;
        double result = invoiceGenerator.calculateFare(distance, time, 10, 1);
        Assertions.assertEquals(55, result, 0);
    }
    @Test
    public void testForGivenDistanceAndTimeShouldPassMinimumFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.2;
        double time = 1;
        double result = invoiceGenerator.calculateFare(distance ,time, 10,1 );
        Assertions.assertEquals(3,result,0);
    }

    @Test
    public void passTestForMultipleRide() {
        Ride[] rides = {
                new Ride(2.0, 5, "", 0),
                new Ride(0.1, 1, "", 0)
        };
        InvoiceSummary summary = InvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0 ,15.0);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    @Test
    public void givenUserIdShouldReturnListOfRides(){
        Ride[] rides1 = { new Ride(0.1, 2.0,"premium",1), new Ride(10.0, 3.0, "normal",2) };
        Ride[] rides2 = { new Ride(3.0, 2, "normal",2), new Ride(1, 3, "premium",1), new Ride(150, 300, "premium",1) };
        Ride[] rides3 = { new Ride(5, 7, "normal",2) };

        rideRepo.put(1, rides1);
        rideRepo.put(2, rides2);
        rideRepo.put(3, rides3);

        InvoiceSummary invoice = new InvoiceSummary(3, 2903, 967.6666666666666);

        Assertions.assertEquals(invoice, InvoiceGenerator.calculateFare(2, rideRepo));
    }
}