package services;

import models.FlightsModel;
import models.TicketsModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class FlightService {
    private static SessionFactory sessionFactory;
    private static Session session;

    //create method
    public static void addFlight(FlightsModel flight) {
        Transaction trans = session.beginTransaction();
        String begin = flight.getBegin();
        String end = flight.getEnd();
        System.out.println(begin);
        System.out.println(end);
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        flight.getBegin().format(myFormatObj);
        session.save(flight);
        trans.commit();
    }

    //read method

    public static FlightsModel getFlightByFlightNumber(int fn) {
     return null;
    }

    public static List<FlightsModel> getAllFlights() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<FlightsModel> query = builder.createQuery(FlightsModel.class);
        Root<FlightsModel> root = query.from(FlightsModel.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    //update method
    public static void CheckInUserByFlightNumber (int fn) {
    }

    //delete method
    public static void deleteFlight(int fn) {
        session.beginTransaction();
        FlightsModel getFlight;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<FlightsModel> query = builder.createQuery(FlightsModel.class);
        Root<FlightsModel> root = query.from(FlightsModel.class);
        query.select(root).where(builder.equal(root.get("flightNumber"), fn));
        getFlight = session.createQuery(query).getSingleResult();
        session.delete(getFlight);
        session.getTransaction().commit();
        //Query query = SessionHolder.getSession().createQuery("DELETE Flight WHERE flightNumber = :flightNumber");
        //query.setParameter("flightNumber", flightNumber);
        //int result = query.executeUpdate(); ----> this will work!
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
