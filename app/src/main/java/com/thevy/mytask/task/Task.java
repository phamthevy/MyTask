package com.thevy.mytask.task;

public class Task {
    int index;
    String taskContent;
    int countCont;
    int countInMonth;


    public Task(int index, String taskContent, int countCont, int countInMonth) {
        this.index = index;
        this.taskContent = taskContent;
        this.countCont = countCont;
        this.countInMonth = countInMonth;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public int getCountCont() {
        return countCont;
    }

    public void setCountCont(int countCont) {
        this.countCont = countCont;
    }

    public int getCountInMonth() {
        return countInMonth;
    }

    public void setCountInMonth(int countInMonth) {
        this.countInMonth = countInMonth;
    }
}

