package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="flights")
public class FlightsModel {

    @Id
    @Column (name = "flight_number")
    private int flightNumber;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private String status;

    @Column
    private Date begin;

    @Column
    private Date end;

    public FlightsModel() {}

    public FlightsModel(int fn) {
        this.flightNumber = fn;
    }


    public FlightsModel(String origin, String destination, int flightNumber, Date begin, Date end) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.begin = begin;
        this.end = end;
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

    public Date getBegin() { return begin; }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
