package com.example.studentmarks.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Request body for POST /api/marks/calculate
 */
public class MarksRequest {

    @Schema(description = "Student's name", example = "Ravi Kumar")
    private String name;

    @Schema(description = "Marks for each subject", example = "[85, 92, 78]")
    private double[] marks;

    public MarksRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }
}
