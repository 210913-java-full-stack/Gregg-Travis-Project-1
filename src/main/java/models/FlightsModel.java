package models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="flights")
public class FlightsModel {

    @Id
    @Column (name = "flight_number")
    private Integer flightNumber;

    @Column (name="user_name")
    private String userName;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private String status;

    @Column
    private Date start;

    @Column
    private Date end;

    //what we need here: We need to associate this flight with all passengers.
    @ManyToMany
    @JoinTable(
            name="flights_passengers",
            joinColumns = @JoinColumn(name="flights"),
            inverseJoinColumns = @JoinColumn(name="passengers")
    )
    private List<UserModel> passengers;

    public FlightsModel() {}

    public FlightsModel(Integer fn) {
        this.flightNumber = fn;
    }


    public FlightsModel(String origin, String destination, Integer flightNumber, Date begin, Date end) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.start = begin;
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

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getStart() { return start; }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
