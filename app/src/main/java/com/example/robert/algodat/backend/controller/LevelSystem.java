package com.example.robert.algodat.backend.controller;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.robert.algodat.backend.model.Level;
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
public class LevelSystem extends Activity {
    private Level lvl;
    private String filename="Level";

    public LevelSystem(){
        this.lvl=new Level();
        File file = new File(getFilesDir(), filename);
        if(file.exists()){
            read();
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
            oOutputStream.writeObject(lvl);
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
            lvl = (Level) ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void winsExam(int xp){
        lvl.setExamXp(lvl.getExamXp()+xp);
        save();
    }

    public void finishesLearn(int xp){
        lvl.setLearnXp(lvl.getLearnXp()+xp);
        save();
    }

    public void finishesPractice(int xp){
        lvl.setPracticeXp(lvl.getPracticeXp()+xp);
        save();
    }
}
