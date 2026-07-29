package com.example.studentmarks.model;

/**
 * Student model.
 *
 * JAVA BASICS USED HERE:
 * - Variables & Data Types: String, int, double, double[]
 * - Arrays: marks[] stores each subject's score
 */
public class Student {

    // ---- Variables & Data Types ----
    private String name;          // text data type
    private int numberOfSubjects; // whole number
    private double[] marks;       // Array data type: holds decimal marks per subject

    public Student() {
    }

    public Student(String name, int numberOfSubjects, double[] marks) {
        this.name = name;
        this.numberOfSubjects = numberOfSubjects;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }
}
