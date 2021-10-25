package services;

import models.TicketsModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketsService {
    private static Session session;

    public static void addTicket(TicketsModel ticket) {
        Transaction trans = session.beginTransaction();
        session.save(ticket);
        trans.commit();
    }

    public static void deleteTicket(Integer tn) {
        TicketsModel ticket;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TicketsModel> query = builder.createQuery(TicketsModel.class);
        Root<TicketsModel> root = query.from(TicketsModel.class);
        query.select(root).where(builder.equal(root.get("ticketNumber"), tn));
        ticket = session.createQuery(query).getSingleResult();
        System.out.println(ticket.getTicketNumber() + ", " + ticket.getFlightNumber() + ", " + ticket.isCheckIn());
        session.beginTransaction();
        session.delete(ticket);
        session.getTransaction().commit();
    }

    /**
     * This method pulls a unique ticket model object by username, and then sets that
     * object's checkin value to true, indicating the ticket holder is present and boarding.
     * @param user
     */
    public static void checkInByUserName(Integer tn, String user) {
        TicketsModel getTicket;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TicketsModel> query = builder.createQuery(TicketsModel.class);
        Root<TicketsModel> root = query.from(TicketsModel.class);
        query.select(root).where(
                builder.and(
                        builder.equal(root.get("userName"), user),
                        builder.equal(root.get("ticketNumber"), tn)));
        getTicket = session.createQuery(query).getSingleResult();
        getTicket.setCheckIn(true);
        Transaction tx = session.beginTransaction();
        session.save(getTicket);
        tx.commit();
    }


    public static List<TicketsModel> getAllTickets() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TicketsModel> query = builder.createQuery(TicketsModel.class);
        Root<TicketsModel> root = query.from(TicketsModel.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        TicketsService.session = session;
    }
}
