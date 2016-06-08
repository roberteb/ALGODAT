package com.example.robert.algodat.backend.controller;

import android.app.Activity;
import android.content.Context;

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

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public LevelSystem(Context context) {
        this.userDAO= new UserDAO(context);
    }

    /*
    gets called when user wins the exam.
    @returns a boolean value if User levels up.
    */
    public boolean winsExam(int xp){
        userDAO.increaseExamXp(xp);
        userDAO.incrementMadeExams();
        return checkLvlUp();
    }
    /*
    gets calles when a user finishes a chapter.
    returns a boolean value if User levels up.
     */
    public boolean finishesLearn(int xp){
        userDAO.increaseLearnXp(xp);
        userDAO.incrementLearned();
        return checkLvlUp();
    }

    /*
    gets calles when a user finishes a practice level.
   returns a boolean value if User levels up.
    */
    public boolean finishesPractice(int xp){
        userDAO.increasePracticeXp(xp);
        userDAO.incrementPractices();
        return checkLvlUp();
    }

    public int getSumXp(){
        return userDAO.getSumXp();
    }
    public int getUserLevel(){
        return userDAO.getUserLevel();
    }
    private boolean checkLvlUp(){
        return userDAO.checkLvlUp();
    }
    public String getUserName(){
       return userDAO.getUser().getName();
    }

    public int getLevel(){
        return userDAO.getUserLevel();
    }

    public int madeExams(){
        return userDAO.getUser().getMadeExams();
    }
    public int madePractices(){
        return userDAO.getUser().getMadePractices();
    }
    public int learnedChapters(){
        return userDAO.getUser().getLearned();
    }
    public int getNextLevel(){
        return userDAO.getUser().getNxtLvlXp()-getSumXp();
    }
}
