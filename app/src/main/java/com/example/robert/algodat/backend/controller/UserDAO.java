package com.example.robert.algodat.backend.controller;

import android.app.Activity;
import android.content.Context;

import com.example.robert.algodat.backend.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by chris on 08.06.2016.
 */
public class UserDAO extends Activity {
   private String filename="User";
   private User user;


    public UserDAO(){
        this.user=new User();
        File file = new File(getFilesDir(), filename);
        if(file.exists()){
            read();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void createUser(String name){
        if(user==null) {
            this.user = new User();
            user.setName(name);
        }else{
            throw new IllegalArgumentException("Only one User is allowed!");
        }
    }

    public void save(){
        File file = new File(getFilesDir(), filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
           ObjectOutputStream oOutputStream = new ObjectOutputStream(new FileOutputStream(file));
           oOutputStream.writeObject(user);
            oOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void read(){
        ObjectInputStream ois= null;
        File file=new File(getFilesDir(), filename);
        if (!file.exists()) {
          return;
        }
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            user = (User) ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public void incrementMadeExams(){
        user.incrementMadeExams();
        save();
    }
    public void incrementPractices(){
        user.incrementMadePractices();
        save();
    }
    public void incrementLearned(){
        user.incrementLearned();
        save();
    }
}
