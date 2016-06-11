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
        read();
        userDAO.increaseExamXp(xp);
        userDAO.incrementMadeExams();
        save();
        return checkLvlUp();
    }
    /*
    gets calles when a user finishes a chapter.
    returns a boolean value if User levels up.
     */
    public boolean finishesLearn(int xp){
        read();
        userDAO.increaseLearnXp(xp);
        userDAO.incrementLearned();
        save();
        return checkLvlUp();
    }

    /*
    gets calles when a user finishes a practice level.
   returns a boolean value if User levels up.
    */
    public boolean finishesPractice(int xp){
        read();
        userDAO.increasePracticeXp(xp);
        userDAO.incrementPractices();
        save();
        return checkLvlUp();
    }

    public int getSumXp(){
        read();
        return userDAO.getSumXp();
    }
    public int getUserLevel(){
        read();
        return userDAO.getUserLevel();
    }
    private boolean checkLvlUp(){
        read();
        boolean lvldup=userDAO.checkLvlUp();
        save();
        return lvldup;
    }
    public String getUserName(){
        read();
       return userDAO.getUser().getName();
    }

    public int getLevel(){
        read();
        return userDAO.getUserLevel();
    }

    public int madeExams(){
        read();
        return userDAO.getUser().getMadeExams();
    }
    public int madePractices(){
        read();
        return userDAO.getUser().getMadePractices();
    }
    public int learnedChapters(){
        read();
        return userDAO.getUser().getLearned();
    }
    public int getNextLevel(){
        read();
        return userDAO.getUser().getNxtLvlXp()-getSumXp();
    }
    public void save(){
        userDAO.save();
    }
    public void read(){
        userDAO.read();
    }
}
