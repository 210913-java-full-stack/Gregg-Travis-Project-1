package servlets;

import models.FlightsModel;
import models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.FlightService;
import services.HibernateService;
import services.TicketsService;
import services.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Configuration config = new Configuration();
        Session session = HibernateService.getSession();
        UserService.setSession(session);
        FlightService.setSession(session);
        TicketsService.setSession(session);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        UserService.getSession().close();
    }
}
