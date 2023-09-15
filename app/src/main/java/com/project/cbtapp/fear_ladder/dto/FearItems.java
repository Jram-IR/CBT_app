package com.project.cbtapp.fear_ladder.dto;

public class FearItems {
    private String name;
    private long anxiety;
    private boolean done = false;

    public FearItems() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(long anxiety) {
        this.anxiety = anxiety;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
