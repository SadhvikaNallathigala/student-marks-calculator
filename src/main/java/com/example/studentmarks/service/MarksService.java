package com.example.studentmarks.service;

import org.springframework.stereotype.Service;

/**
 * MarksService holds all the calculation logic.
 *
 * JAVA BASICS USED HERE:
 * - Methods: each calculation is its own reusable method
 * - Loops: "for" loop to add up marks stored in the array
 * - Operators: +=, /, >=, ==  (arithmetic, relational)
 * - If, Else: grade boundaries (A/B/C/D/F)
 * - Switch: turning a grade letter into a remark
 */
@Service
public class MarksService {

    /**
     * LOOPS + OPERATORS + ARRAYS
     * Adds up every mark in the array using a for loop.
     */
    public double calculateTotal(double[] marks) {
        double total = 0; // variable to accumulate the sum

        // "for" loop walks through every element of the array
        for (int i = 0; i < marks.length; i++) {
            total += marks[i]; // += is a shorthand arithmetic operator
        }
        return total;
    }

    /**
     * METHODS + OPERATORS
     * Average = total / count. Calls calculateTotal() -> methods calling methods.
     */
    public double calculateAverage(double[] marks) {
        if (marks.length == 0) {
            return 0; // avoid divide-by-zero
        }
        double total = calculateTotal(marks);
        return total / marks.length; // division operator
    }

    /**
     * IF / ELSE
     * Relational operators (>=) decide which grade band the average falls into.
     */
    public String calculateGrade(double average) {
        String grade;

        if (average >= 90) {
            grade = "A";
        } else if (average >= 75) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }

    /**
     * SWITCH
     * Converts a grade letter into a human-readable remark.
     */
    public String getRemark(String grade) {
        String remark;

        switch (grade) {
            case "A":
                remark = "Excellent!";
                break;
            case "B":
                remark = "Very Good";
                break;
            case "C":
                remark = "Good";
                break;
            case "D":
                remark = "Needs Improvement";
                break;
            case "F":
                remark = "Failed - Study Harder";
                break;
            default:
                remark = "Invalid Grade";
        }
        return remark;
    }

    /**
     * LOOPS + OPERATORS
     * Finds the highest mark scored by the student (relational operator > used in a loop).
     */
    public double findHighestMark(double[] marks) {
        double highest = marks.length > 0 ? marks[0] : 0; // ternary operator

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    /**
     * LOOPS + OPERATORS
     * Finds the lowest mark scored by the student.
     */
    public double findLowestMark(double[] marks) {
        double lowest = marks.length > 0 ? marks[0] : 0;

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        return lowest;
    }

    /**
     * OPERATORS
     * Checks pass/fail using a logical/relational operator.
     */
    public boolean isPassing(double average) {
        return average >= 40; // pass mark threshold
    }

    /**
     * SWITCH
     * Converts a letter grade into a grade point on a 10-point scale, used for GPA.
     */
    public double gradePointFor(String grade) {
        double points;

        switch (grade) {
            case "A":
                points = 10;
                break;
            case "B":
                points = 8;
                break;
            case "C":
                points = 6;
                break;
            case "D":
                points = 4;
                break;
            case "F":
                points = 0;
                break;
            default:
                points = 0;
        }
        return points;
    }

    /**
     * LOOPS + METHODS
     * GPA = average grade point across every individual subject
     * (reuses calculateGrade() per-subject instead of just the overall average).
     */
    public double calculateGPA(double[] marks) {
        if (marks.length == 0) {
            return 0;
        }
        double totalPoints = 0;
        for (int i = 0; i < marks.length; i++) {
            String subjectGrade = calculateGrade(marks[i]);
            totalPoints += gradePointFor(subjectGrade);
        }
        return totalPoints / marks.length;
    }

    /**
     * IF / ELSE
     * Maps the overall average to a division/class, like a real report card.
     */
    public String calculateDivision(double average) {
        String division;

        if (average >= 75) {
            division = "Distinction";
        } else if (average >= 60) {
            division = "First Division";
        } else if (average >= 50) {
            division = "Second Division";
        } else if (average >= 40) {
            division = "Third Division";
        } else {
            division = "Fail";
        }
        return division;
    }

    /**
     * LOOPS + OPERATORS
     * Counts how many individual subjects meet the pass mark.
     */
    public int countPassingSubjects(double[] marks) {
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 40) {
                count++;
            }
        }
        return count;
    }

    /**
     * METHODS
     * Failing subjects = total subjects - passing subjects.
     */
    public int countFailingSubjects(double[] marks) {
        return marks.length - countPassingSubjects(marks);
    }

    /**
     * LOOPS + OPERATORS
     * Same idea as findHighestMark(), but returns the ARRAY INDEX
     * so the controller can look up which subject name that was.
     */
    public int findHighestIndex(double[] marks) {
        int highestIndex = 0;
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > marks[highestIndex]) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    /**
     * LOOPS + OPERATORS
     * Same idea as findLowestMark(), but returns the ARRAY INDEX.
     */
    public int findLowestIndex(double[] marks) {
        int lowestIndex = 0;
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < marks[lowestIndex]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }
}
