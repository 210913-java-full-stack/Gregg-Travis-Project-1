package models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserModel {

    @Id
    @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "password")
    private String pass;

    @Column (name = "first_name")
    private String fName;

    @Column (name = "last_name;")
    private String lName;

    @Column
    private int role;

    //Sign-in Constructor

    public UserModel(String user_name, String pass, int role) {
        this.userName = user_name;
        this.pass = pass;
        this.role = role;
    }

    //Register constructor

    public UserModel(String user_name, String pass, String firstName, String lastName, int role) {
        this.userName = user_name;
        this.pass = pass;
        this.fName = firstName;
        this.lName = lastName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String firstName) {
        this.fName = firstName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lastName) {
        this.lName = lastName;
    }

    public int isRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}


