package services;

import models.FlightsModel;
import models.TicketsModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FlightService {
    private static SessionFactory sessionFactory;
    private static Session session;

    //create method

    /**
     * This method takes in the flight information that's been put into a FlightModel, begins a transaction, saves the
     * FlightModel to the flights table via Hibernate then commits the change to the table
     * @param flight
     */
    public static void addFlight(FlightsModel flight) {
        Transaction trans = session.beginTransaction();
        flight.setStatus("ON TIME");
        session.save(flight);
        trans.commit();
    }

    //read method

    /**
     * This function will get all records in the flights table and return it in a List format to be sent to the calling
     * website to be put into a table
     * @return
     */
    public static List<FlightsModel> getAllFlights() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<FlightsModel> query = builder.createQuery(FlightsModel.class);
        Root<FlightsModel> root = query.from(FlightsModel.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    /**
     * This method will query and change two tables. The first query will search for the flight number (fn) brought in
     * by the webpage it will take the record and change the status to CANCELLED. The second query will search for all
     * tickets that havE the fn brought in and using a for each table change all status(es) to "CANCELLED" then commit
     * all changes.
     * @param fn
     */
    //delete method
    public static void deleteFlight(int fn) {
        session.beginTransaction();
        FlightsModel getFlight;
        List<TicketsModel> getTicket;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<FlightsModel> deleteQuery = builder.createQuery(FlightsModel.class);
        Root<FlightsModel> deleteRoot = deleteQuery.from(FlightsModel.class);
        deleteQuery.select(deleteRoot).where(builder.equal(deleteRoot.get("flightNumber"), fn));
        getFlight = session.createQuery(deleteQuery).getSingleResult();
        getFlight.setStatus("CANCELLED");
        session.update(getFlight);
        CriteriaQuery<TicketsModel> updateQuery = builder.createQuery(TicketsModel.class);
        Root<TicketsModel> updateRoot = updateQuery.from(TicketsModel.class);
        updateQuery.select(updateRoot).where(builder.equal(updateRoot.get("flightNumber"), fn));
        getTicket = session.createQuery(updateQuery).getResultList();
        for (TicketsModel ticketsModel : getTicket) {
            ticketsModel.setStatus("CANCELLED");
            session.update(ticketsModel);
        }
        session.getTransaction().commit();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        FlightService.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        FlightService.session = session;
    }
}
