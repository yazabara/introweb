package com.zabara.introweb.domain;

import java.io.Serializable;

/**
 * Created by Yaroslav on 31.05.2014.
 *
 * Simple contact
 */
public class Contact implements Serializable{

    private String firstName;
    private String password;

    public Contact(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
