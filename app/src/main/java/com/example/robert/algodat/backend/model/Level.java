package com.example.robert.algodat.backend.model;

/**
 * Created by chris on 08.06.2016.
 */
public class Level {
    private int examXp;
    private int learnXp;
    private int practiceXp;
    private int lvl;

    public Level(){
        examXp=0;
        learnXp=0;
        practiceXp=0;
        lvl=0;
    }
    public int getExamXp() {
        return examXp;
    }

    public void setExamXp(int examXp) {
        this.examXp = examXp;
    }

    public int getLearnXp() {
        return learnXp;
    }

    public void setLearnXp(int learnXp) {
        this.learnXp = learnXp;
    }

    public int getPracticeXp() {
        return practiceXp;
    }

    public void setPracticeXp(int practiceXp) {
        this.practiceXp = practiceXp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl){
        this.lvl=lvl;
    }
}
