package com.project.cbtapp.fear_ladder.dto;


import java.util.ArrayList;

public class FearModel {


    private String id;
    private String fearName;

    private ArrayList<FearItems> fearList = new ArrayList<>();

    public FearModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFearName() {
        return fearName;
    }

    public void setFearName(String fearName) {
        this.fearName = fearName;
    }

    public ArrayList<FearItems> getFearList() {
        return fearList;
    }

    public void setFearList(ArrayList<FearItems> fearList) {
        this.fearList = fearList;
    }
}
