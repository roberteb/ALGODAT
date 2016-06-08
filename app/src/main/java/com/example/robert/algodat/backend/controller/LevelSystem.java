package com.example.robert.algodat.backend.controller;

import android.app.Activity;

import com.example.robert.algodat.backend.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by chris on 08.06.2016.
 */
public class LevelSystem {
    UserDAO userDAO;

    public LevelSystem() {
        this.userDAO= new UserDAO();
    }

    public void winsExam(int xp){
        userDAO.increaseExamXp(xp);
        userDAO.incrementMadeExams();
    }

    public void finishesLearn(int xp){
        userDAO.increaseLearnXp(xp);
        userDAO.incrementLearned();
    }

    public void finishesPractice(int xp){
        userDAO.increasePracticeXp(xp);
        userDAO.incrementPractices();
    }

}
