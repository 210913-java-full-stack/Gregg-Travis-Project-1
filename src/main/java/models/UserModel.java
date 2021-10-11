package models;

public class UserModel {
    private String userName;
    private String pass;
    private String firstName;
    private String lastName;
    private boolean role;

    //Sign-in Constructor

    public UserModel(String userName, String pass, boolean role) {
        this.userName = userName;
        this.pass = pass;
        this.role = role;
    }

    //Register constructor

    public UserModel(String userName, String pass, String firstName, String lastName, boolean role) {
        this.userName = userName;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}


