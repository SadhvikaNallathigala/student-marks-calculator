package com.example.studentmarks.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response body returned by POST /api/marks/calculate
 */
public class MarksResponse {

    @Schema(example = "Ravi Kumar")
    private String name;

    private double[] marks;

    @Schema(example = "255.0")
    private double total;

    @Schema(example = "85.0")
    private double average;

    @Schema(example = "92.0")
    private double highest;

    @Schema(example = "78.0")
    private double lowest;

    @Schema(example = "B")
    private String grade;

    @Schema(example = "Very Good")
    private String remark;

    @Schema(example = "true")
    private boolean passing;

    public MarksResponse() {
    }

    public MarksResponse(String name, double[] marks, double total, double average,
                          double highest, double lowest, String grade, String remark, boolean passing) {
        this.name = name;
        this.marks = marks;
        this.total = total;
        this.average = average;
        this.highest = highest;
        this.lowest = lowest;
        this.grade = grade;
        this.remark = remark;
        this.passing = passing;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double[] getMarks() { return marks; }
    public void setMarks(double[] marks) { this.marks = marks; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getAverage() { return average; }
    public void setAverage(double average) { this.average = average; }

    public double getHighest() { return highest; }
    public void setHighest(double highest) { this.highest = highest; }

    public double getLowest() { return lowest; }
    public void setLowest(double lowest) { this.lowest = lowest; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public boolean isPassing() { return passing; }
    public void setPassing(boolean passing) { this.passing = passing; }
}
