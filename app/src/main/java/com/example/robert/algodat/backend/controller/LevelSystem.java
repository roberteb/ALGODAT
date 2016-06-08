package com.example.robert.algodat.backend.controller;

/**
 * Created by chris on 08.06.2016.
 */
public class LevelSystem {
    private UserDAO userDAO;

    public LevelSystem(){
        this.userDAO= new UserDAO();
    }

    public void winsExam(){
        userDAO.increaseExamXp(50);
        userDAO.incrementMadeExams();
    }

    public void finishesLearn(){
        userDAO.increaseLearnXp(100);
        userDAO.incrementLearned();
    }

    public void finishesPractice(){
        userDAO.increasePracticeXp(50);
        userDAO.incrementPractices();
    }
}
