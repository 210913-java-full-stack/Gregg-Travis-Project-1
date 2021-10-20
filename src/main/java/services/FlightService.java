package services;

import models.FlightsModel;
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
    public static void addFlight(FlightsModel flight) {
        Transaction trans = session.beginTransaction();
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

    //delete method
    public static void deleteFlight(int fn) {
        FlightsModel flight = new FlightsModel(fn);
        session.delete(fn);
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
