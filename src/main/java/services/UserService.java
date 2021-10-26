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

    /**
     * This method takes in the user information that's been put into a UserModel, begins a transaction, saves the user
     * to the users table via Hibernate then commits the change to the table
     * @param user
     */
    public static void saveNewUser(UserModel user) {
        Transaction trans = session.beginTransaction();
        session.save(user);
        trans.commit();
    }

    //read methods

    /**
     * This method takes in userName and password from the webpage, queries the database and returns a UserModel that is
     * either null or has the data that matches the userName and password from the database
     * @param user
     * @param pass
     * @return
     */
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

    /**
     * This method queries the database if any record has the userName brought into the method and puts in into a List.
     * If the List is empty the method will return true(the userName is unique) otherwise the result is false (the user
     * exists in the database)
     * @param username
     * @return
     */
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
