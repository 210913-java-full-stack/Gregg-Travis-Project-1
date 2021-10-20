package models;

import javax.persistence.*;

@Entity
@Table (name="tickets")
public class TicketsModel {
    @Id
    @Column (name="ticket_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketNumber;

    @Column (name="user_name")
    private String userName;

    @Column (name="flight_number")
    private Integer flightNumber;



    public TicketsModel() {}

    public TicketsModel(String userName, Integer flightNumber) {
        this.userName = userName;
        this.flightNumber = flightNumber;
        //this.isCheckedIn = false;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }
}
