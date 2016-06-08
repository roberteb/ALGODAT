package com.example.robert.algodat.backend.model;

/**
 * Created by chris on 08.06.2016.
 */
public class User {
    private String name;
    private String password;
    private Level lvl;
    private int madeExams;
    private int madePractices;
    private int learned;

    public User(){
        this.name="Anonymous";
        this.password="0000";
        madeExams=0;
        madePractices=0;
        learned=0;
        lvl= new Level();
    }
}
