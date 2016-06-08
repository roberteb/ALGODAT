package com.example.robert.algodat.backend.controller;

import com.example.robert.algodat.backend.model.User;

import java.util.ArrayList;

/**
 * Created by chris on 08.06.2016.
 */
public class UserDAO {

    ArrayList<User> users;

    public UserDAO() {
        this.users = new ArrayList<User>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public User getUserbyName(){
        User user=null;
        return user;
    }
}
