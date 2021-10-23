package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="flights")
public class FlightsModel {

    @Id
    @Column (name = "flight_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightNumber;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private String begin;

    @Column
    private String end;

    @OneToMany
    List<TicketsModel> tickets;

    public FlightsModel() {}

    public FlightsModel(int fn) {
        this.flightNumber = fn;
    }


    public FlightsModel(String origin, String destination, int flightNumber, String begin, String end) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.begin = begin;
        this.end = end;
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

    public String getBegin() { return begin; }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}