package models;

import java.util.Date;

public class FlightsModel {
    private String origin, destination, status;
    private int flightNumber;
    private Date eta;
    private boolean checkIn;

    public FlightsModel(int fn) {
        this.flightNumber = fn;
    }


    public FlightsModel(String origin, String destination, int flightNumber, Date eta) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.eta = eta;
        this.status = "Pre-Flight";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }
}
