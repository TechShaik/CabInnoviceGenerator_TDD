package com.Files;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride ride = new Ride(10, 15); // 10 km, 15 min
        double fare = invoiceService.calculateFare(ride, false);
        assertEquals(115, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenBelowMinimumFare_ShouldReturnMinimumFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride ride = new Ride(0.5, 2); // very short ride
        double fare = invoiceService.calculateFare(ride, false);
        assertEquals(5.0, fare, 0.0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = { new Ride(10, 15), new Ride(5, 10) }; // two rides
        InvoiceSummary summary = invoiceService.calculateFare(rides, false);
        assertEquals(2, summary.getTotalRides());
        assertEquals(190, summary.getTotalFare(), 0.0);
        assertEquals(95, summary.getAverageFarePerRide(), 0.0);
    }

    @Test
    public void givenPremiumRides_ShouldCalculateWithPremiumRates() {
        InvoiceService invoiceService = new InvoiceService();
        Ride ride = new Ride(10, 15); // 10 km, 15 min, premium
        double fare = invoiceService.calculateFare(ride, true);
        assertEquals(180, fare, 0.0);
    } 
}