package services;

import models.FlightsModel;
import models.TicketsModel;
import models.UserModel;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class HibernateService {
    public static Session session;

    private HibernateService() {
    }

    private static void configSession() {
        //Set up hibernate properties
        Configuration config = new Configuration();
        //if(System.getProperty("TEST") == "TRUE") {
            //we are getting hibernate config info from System properties. Probably for running on a Tomcat server on AWS
            //System.getenv("TEST");//Tomcat on elastic beanstalk will not see these
            //System.getProperty("TEST");//Tomcat on EBS will see these. That's why we use them below.

            //This part isn't necessary if we are bundling

//            config.setProperty("hibernate.dialect", System.getProperty("HIBERNATE_DIALECT"));
//            config.setProperty("hibernate.connection.driver_class", System.getProperty("HIBERNATE_CONNECTION_DRIVER_CLASS"));
//            config.setProperty("hibernate.connection.url", System.getProperty("HIBERNATE_CONNECTION_URL"));
//            config.setProperty("hibernate.connection.username", System.getProperty("HIBERNATE_CONNECTION_USERNAME"));
//            config.setProperty("hibernate.connection.password", System.getProperty("HIBERNATE_CONNECTION_PASSWORD"));
//            config.setProperty("hibernate.hbm2ddl.auto", System.getProperty("HIBERNATE_HBM2DDL_AUTO"));
//            config.setProperty("hibernate.connection.autocommit", System.getProperty("HIBERNATE_CONNECTION_AUTOCOMMIT"));
//            config.setProperty("hibernate.show_sql", System.getProperty("HIBERNATE_SHOW_SQL"));
//        }


        //add model classes
        config.addAnnotatedClass(UserModel.class);
        config.addAnnotatedClass(FlightsModel.class);
        config.addAnnotatedClass(TicketsModel.class);

        //open session
        session = config.buildSessionFactory().openSession();

    }

    public static Session getSession(){
        if(session == null) {
            configSession();
        }
        return session;
    }

    public static void closeSession(){
        session.close();
        session = null;
    }


}
