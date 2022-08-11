package com.Bridgelabz.InvoiceService;

public class InvoiceSummary {
    int noOfRides;
    double totalFare;
    double averageFare;
    public InvoiceSummary(int noOfRides, double totalFare , double averageFare ) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||  getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o ;
        return noOfRides == that.noOfRides &&
                Double.compare( that.totalFare, totalFare) == 0 &&
                Double.compare (that.averageFare, averageFare) == 0;
    }
    @Override
    public String toString() {
        return "Invoice [rideCount=" + noOfRides + ", totalFare=" + totalFare + ", avgFare=" + averageFare + "]";
    }
}

