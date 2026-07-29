package com.example.studentmarks.controller;

import com.example.studentmarks.service.MarksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Tag(name = "Web Pages", description = "HTML pages (Thymeleaf) - the browser UI flow, not JSON")
public class MarksController {

    @Autowired
    private MarksService marksService;

    /**
     * STEP 1: Show the first form - ask for name & number of subjects.
     */
    @Operation(summary = "Step 1: Show the student details form")
    @GetMapping("/")
    public String showStartForm() {
        return "index"; // renders templates/index.html
    }

    /**
     * STEP 2: Based on numberOfSubjects, dynamically build a form
     * with that many mark input boxes (Thymeleaf loop does this).
     */
    @Operation(summary = "Step 2: Generate the dynamic marks-entry form")
    @PostMapping("/generate-form")
    public String generateMarksForm(@RequestParam String name,
                                     @RequestParam int numberOfSubjects,
                                     @RequestParam(required = false, defaultValue = "") String examName,
                                     Model model) {
        model.addAttribute("name", name);
        model.addAttribute("numberOfSubjects", numberOfSubjects);
        model.addAttribute("examName", examName);
        return "marksForm"; // renders templates/marksForm.html
    }

    /**
     * STEP 3: Receive all entered marks (and now subject names) as ARRAYS, run the
     * calculations using MarksService (loops, if-else, switch, operators), show the report.
     */
    @Operation(summary = "Step 3: Calculate and show the report card page")
    @PostMapping("/calculate")
    public String calculateResult(@RequestParam String name,
                                   @RequestParam(required = false, defaultValue = "") String examName,
                                   @RequestParam String[] subjectNames, // <-- new: one name per subject
                                   @RequestParam double[] marks,        // <-- array of marks
                                   Model model) {

        double average = marksService.calculateAverage(marks);
        double total = marksService.calculateTotal(marks);
        String grade = marksService.calculateGrade(average);
        String remark = marksService.getRemark(grade);
        double highest = marksService.findHighestMark(marks);
        double lowest = marksService.findLowestMark(marks);
        boolean passing = marksService.isPassing(average);

        // ---- NEW: advanced report-card stats ----
        double gpa = marksService.calculateGPA(marks);
        String division = marksService.calculateDivision(average);
        int passCount = marksService.countPassingSubjects(marks);
        int failCount = marksService.countFailingSubjects(marks);
        int highestIndex = marksService.findHighestIndex(marks);
        int lowestIndex = marksService.findLowestIndex(marks);
        String highestSubject = subjectNames[highestIndex];
        String lowestSubject = subjectNames[lowestIndex];

        // per-subject grade, so the report table can show a grade next to each mark
        String[] subjectGrades = new String[marks.length];
        for (int i = 0; i < marks.length; i++) {
            subjectGrades[i] = marksService.calculateGrade(marks[i]);
        }

        model.addAttribute("name", name);
        model.addAttribute("examName", examName);
        model.addAttribute("subjectNames", subjectNames);
        model.addAttribute("subjectGrades", subjectGrades);
        model.addAttribute("marks", marks);
        model.addAttribute("total", total);
        model.addAttribute("average", average);
        model.addAttribute("grade", grade);
        model.addAttribute("remark", remark);
        model.addAttribute("highest", highest);
        model.addAttribute("lowest", lowest);
        model.addAttribute("highestSubject", highestSubject);
        model.addAttribute("lowestSubject", lowestSubject);
        model.addAttribute("passing", passing);
        model.addAttribute("gpa", gpa);
        model.addAttribute("division", division);
        model.addAttribute("passCount", passCount);
        model.addAttribute("failCount", failCount);

        return "result"; // renders templates/result.html
    }
}
