package services;

import models.TicketsModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketsService {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void addTicket(TicketsModel ticket) {
        Transaction trans = session.beginTransaction();
        session.save(ticket);
        trans.commit();
    }

    public static void deleteTicket(Integer tn) {
        TicketsModel ticket = new TicketsModel(tn);
        session.delete(ticket);
    }

    public static List<TicketsModel> getAllTickets() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TicketsModel> query = builder.createQuery(TicketsModel.class);
        Root<TicketsModel> root = query.from(TicketsModel.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void checkIn(Integer tn) {
        TicketsModel ticket = new TicketsModel();
        ticket.setCheckIn(true);
    }
}
