package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class UserModel {

    @Id
    @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "password")
    private String pass;

    @Column (name = "first_name")
    private String fName;

    @Column (name = "last_name")
    private String lName;

    @Column
    private Integer role;

    @Column (name="checked_in")
    private boolean isCheckedIn;

    //What we need here: We need to associate users with the flights they will take
    @ManyToMany
    private List<FlightsModel> flights;


    //Sign-in Constructor
    public UserModel() {}

    public UserModel(String user_name, String pass, Integer role) {
        this.userName = user_name;
        this.pass = pass;
        this.role = role;
    }

    //Register constructor

    public UserModel(String userName, String pass, String fName, String lName, Integer role) {
        this.userName = userName;
        this.pass = pass;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.isCheckedIn = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}


