package models;

import javax.persistence.*;

@Entity
@Table (name="tickets")
public class TicketsModel {
    @Id
    @Column (name="ticket_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketNumber;

    @Column (name="user_name")
    private String userName;

    @Column (name="flight_number")
    private int flightNumber;

    @Column (name="checked_in")
    private boolean isCheckedIn;

    public TicketsModel() {}

    public TicketsModel(String userName, int flightNumber) {
        this.userName = userName;
        this.flightNumber = flightNumber;
        this.isCheckedIn = false;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
}
