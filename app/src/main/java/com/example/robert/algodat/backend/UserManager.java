package com.example.robert.algodat.backend;

import com.example.robert.algodat.backend.controller.LevelSystem;
import com.example.robert.algodat.backend.controller.UserDAO;

/**
 * Created by chris on 08.06.2016.
 */
public class UserManager {
    private UserDAO userDAO;
    private LevelSystem levelSystem;
    public UserManager(){

        this.levelSystem= new LevelSystem();
        this.userDAO= new UserDAO();
    }

}
