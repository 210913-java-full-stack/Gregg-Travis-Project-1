package models;

public class FlightsModel {
    private String origin;
    private String destination;
    private int flightNumber;
    private double eta;
    private boolean checkIn;

    public FlightsModel(String origin, String destination, int flightNumber, double eta) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.eta = eta;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getEta() {
        return eta;
    }

    public void setEta(double eta) {
        this.eta = eta;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }
}
