package servlets;

import models.FlightsModel;
import models.TicketsModel;
import models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.FlightService;
import services.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(UserModel.class);
        config.addAnnotatedClass(FlightsModel.class);
//        config.addAnnotatedClass(TicketsModel.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        UserService.setSessionFactory(sessionFactory);//it isn't really necessary to store both session and sessionfactory here
        UserService.setSession(session);
        FlightService.setSessionFactory(sessionFactory);//it isn't really necessary to store both session and sessionfactory here
        FlightService.setSession(session);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        UserService.getSession().close();
    }
}
