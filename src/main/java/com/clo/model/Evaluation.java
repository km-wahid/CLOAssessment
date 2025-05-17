package com.clo.model;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {

    private String assignType; // assessmentType
    private int totalSt;
    private List<Student> students;
    private List<Double> maxMarksCLO;

    public Evaluation(String assignType, int totalSt) {

        this.assignType = assignType.toLowerCase();

        this.totalSt = totalSt;
        this.students = new ArrayList<>();
        this.maxMarksCLO = new ArrayList<>();
        initMaxMarks();
    }

    private void initMaxMarks() {
        maxMarksCLO.clear();

        switch (assignType) {

            case "midterm":
                fillMaxMarks(4, 5.0);
                break;

            case "final":
                fillMaxMarks(4, 12.5);
                break;

            case "assignment":
                fillMaxMarks(1, 10.0);
                break;

            default:
                throw new IllegalArgumentException("Unsupported assessment type: " + assignType);
        }
    }

    private void fillMaxMarks(int count, double markPerCLO) {
        for (int i = 0; i < count; i++) {

            maxMarksCLO.add(markPerCLO);
        }

    }

    public void addStudent(Student student) {

        if (students.size() >= totalSt) {

            throw new IllegalStateException("Cannot add more students than declared: " + totalSt);
        }

        students.add(student);
    }

    public void calStdPer() {

        for (Student student : students) {

            List<Double> scores = student.getCloScores();
            List<Double> percentages = new ArrayList<>();

            double totalPercentage = 0.00;

            for (int i = 0; i < scores.size(); i++) {
                double maxMark = maxMarksCLO.get(i);
                double percent = (scores.get(i) / maxMark) * 100.0;
                percentages.add(percent);
                totalPercentage += percent;
            }

            student.setCloPercentages(percentages);

            student.setOverallAverage(totalPercentage / scores.size());
        }

    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Double> getMaxMarksPerCLO() {
        return maxMarksCLO;
    }

    public List<Double> calculateClassAverages() {
        List<Double> averages = new ArrayList<>();
        int cloCount = maxMarksCLO.size();

        for (int i = 0; i < cloCount; i++) {
            double total = 0.0;
            for (Student student : students) {
                total += student.getCloPercentages().get(i);
            }

            averages.add(total / students.size());
        }

        return averages;
    }

    public List<Boolean> checkFulfillment(List<Double> classAverages) {
        List<Boolean> fulfillment = new ArrayList<>();

        for (Double avg : classAverages) {
            fulfillment.add(avg >= 60.0);
        }

        return fulfillment;
    }
}
