package com.example.studentmarks.controller;

import com.example.studentmarks.model.MarksRequest;
import com.example.studentmarks.model.MarksResponse;
import com.example.studentmarks.service.MarksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * JSON REST API version of the calculator - separate from the HTML pages.
 * This is what Swagger UI is really meant to document: pure request-in / response-out endpoints.
 *
 * Try it at: http://localhost:8080/swagger-ui.html
 */
@RestController
@RequestMapping("/api/marks")
@Tag(name = "Marks API", description = "Endpoints for calculating student marks, average, grade and pass/fail")
public class MarksApiController {

    @Autowired
    private MarksService marksService;

    @Operation(summary = "Health check", description = "Simple endpoint to confirm the API is running")
    @GetMapping("/health")
    public String health() {
        return "Marks API is up and running";
    }

    @Operation(
            summary = "Calculate a student's result",
            description = "Takes a student's name and an array of subject marks, "
                    + "returns total, average, highest, lowest, grade, remark and pass/fail status."
    )
    @PostMapping("/calculate")
    public MarksResponse calculate(@RequestBody MarksRequest request) {

        double[] marks = request.getMarks();

        double total = marksService.calculateTotal(marks);
        double average = marksService.calculateAverage(marks);
        double highest = marksService.findHighestMark(marks);
        double lowest = marksService.findLowestMark(marks);
        String grade = marksService.calculateGrade(average);
        String remark = marksService.getRemark(grade);
        boolean passing = marksService.isPassing(average);

        return new MarksResponse(
                request.getName(), marks, total, average, highest, lowest, grade, remark, passing
        );
    }
}
