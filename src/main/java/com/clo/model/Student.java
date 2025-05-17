package com.clo.model;

import java.util.List;

public class Student {
    private int id;
    private List<Double> cloScore;
    private List<Double> cloPercentages;
    private double overallAvg;

    public Student(int id, List<Double> cloScore) {
        this.id = id;
        this.cloScore = cloScore;
        this.cloPercentages = null;
        this.overallAvg = 0.0;
    }

    public int getId() {
        return id;
    }

    public List<Double> getCloScores() {
        return cloScore;
    }

    public void setCloScores(List<Double> cloScore) {
        this.cloScore = cloScore;
    }

    public List<Double> getCloPercentages() {
        return cloPercentages;
    }

    public void setCloPercentages(List<Double> cloPercentages) {
        this.cloPercentages = cloPercentages;
    }

    public double getOverallAverage() {
        return overallAvg;
    }

    public void setOverallAverage(double overallAvg) {
        this.overallAvg = overallAvg;
    }
}
