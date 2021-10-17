package servlets;

import models.UserModel;
import org.hibernate.cfg.Configuration;
import services.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(UserModel.class);
        UserService.setSessionFactory(config.buildSessionFactory());
        UserService.setSession(UserService.getSessionFactory().openSession());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        UserService.getSession().close();
    }
}
