package servlets;

import models.UserModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.FlightService;
import services.HibernateService;
import services.TicketsService;
import services.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Session session = HibernateService.getSession();
        UserService.setSession(session);
        FlightService.setSession(session);
        TicketsService.setSession(session);
        UserModel gregg = new UserModel("Gfriedman", "456", "Gregg", "Friedman", 2);
        UserModel travis = new UserModel("Thood", "789", "Travis", "Hood", 2);
        Transaction transaction = session.beginTransaction();
        session.save(gregg);
        session.save(travis);
        transaction.commit();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        UserService.getSession().close();
    }
}
