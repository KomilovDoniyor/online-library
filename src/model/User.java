/**
 * Author : Komilov Doniyor
 * Date : 12/22/2023
 * Project Name : online-library
 */
package model;

import enums.Role;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;

    private String firstname;
    private String lastname;

    private String email;

    private String password;

    private Role role;

    private boolean signIn;

    private List<Book> books = new ArrayList<>();

    public User(Integer id, String firstname, String lastname, String email, String password, Role role, boolean signIn) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.signIn = signIn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isSignIn() {
        return signIn;
    }

    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String toStringUser() {
        return String.format("%1$-5s", id)
                + String.format("%1$-15s", firstname)
                + String.format("%1$-15s", lastname)
                + String.format("%1$-15s", email)
                + String.format("%1$-15s", role);
    }
}
