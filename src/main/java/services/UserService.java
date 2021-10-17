package services;

import models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserService {
    private static SessionFactory sessionFactory;
    private static Session session;

    //create method

    public static void saveNewUser(UserModel user) {
        Transaction trans = session.beginTransaction();
        session.save(user);
        trans.commit();
    }

    //read methods
    public static UserModel getUserById(int id) {
        return session.get(UserModel.class, id);
    }
    public static List<UserModel> getAllToDoItems() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserModel> query = builder.createQuery(UserModel.class);
        Root<UserModel> root = query.from(UserModel.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    //delete method

    public static void deleteUser(UserModel user) {
        session.delete(user);
    }

    //getters and setters


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        UserService.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        UserService.session = session;
    }
}