package services;

import models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
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
    public static UserModel checkUserByUserPass(String user, String pass) {
        UserModel checkUser;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserModel> query = builder.createQuery(UserModel.class);
        Root<UserModel> root = query.from(UserModel.class);
        query.select(root).where(
                builder.and(
                    builder.equal(root.get("userName"), user),
                    builder.equal(root.get("pass"), pass)));
        checkUser = session.createQuery(query).getSingleResult();
        return checkUser;
    }
    public static UserModel checkAdmin(String user, String pass) {
        UserModel checkAdmin;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserModel> query = builder.createQuery(UserModel.class);
        Root<UserModel> root = query.from(UserModel.class);
        query.select(root).where(
                builder.and(
                        builder.equal(root.get("userName"), user),
                        builder.equal(root.get("pass"), pass)));
        checkAdmin = session.createQuery(query).getSingleResult();
        return checkAdmin;
    }

    public static boolean uniqueUsername(String username)
    {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserModel> query = builder.createQuery(UserModel.class);
        Root<UserModel> root = query.from(UserModel.class);
        query.select(root).where(builder.equal(root.get("userName"), username));
        List<UserModel> userList = session.createQuery(query).getResultList();

        return userList.isEmpty();
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
