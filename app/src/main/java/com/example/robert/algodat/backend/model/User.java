package com.example.robert.algodat.backend.model;

/**
 * Created by chris on 08.06.2016.
 */
public class User {
    private String name;
    private String password;
    private int lvl;
    private int madeExams;
    private int madePractices;
    private int learned;

    public User(){
        this.name="Anonymous";
        this.password="0000";
        madeExams=0;
        madePractices=0;
        learned=0;
        lvl=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getMadeExams() {
        return madeExams;
    }

    public void setMadeExams(int madeExams) {
        this.madeExams = madeExams;
    }

    public int getMadePractices() {
        return madePractices;
    }

    public void setMadePractices(int madePractices) {
        this.madePractices = madePractices;
    }

    public int getLearned() {
        return learned;
    }

    public void setLearned(int learned) {
        this.learned = learned;
    }

    public void incrementMadeExams(){
        madeExams++;
    }

    public void incrementMadePractices(){
        madePractices++;
    }

    public void incrementLearned(){
        this.learned++;
    }
}
