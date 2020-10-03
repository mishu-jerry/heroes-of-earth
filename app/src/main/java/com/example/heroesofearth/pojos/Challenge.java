package com.example.heroesofearth.pojos;

public class Challenge {

    private String task;
    private boolean isCompleted;

    public Challenge(String task) {
        this.task = task;
        this.isCompleted = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void toggleCompleted() {
        isCompleted = !isCompleted;
    }
}
