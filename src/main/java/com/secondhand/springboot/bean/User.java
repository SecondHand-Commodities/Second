package com.secondhand.springboot.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rzw
 * @create 2019-12-13-16:45
 */
public class User {
    private String id;
    private String userName;
    private String password;
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {

        return person;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
