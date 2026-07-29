# Student Marks Calculator (Spring Boot)

A 3-step web app: enter name & subject count → enter marks → get a full report card
(total, average, highest, lowest, grade, remark, pass/fail).

## How to run

**Requirements:** Java 17+, Maven (or use the included IDE support in IntelliJ/VS Code).

```bash
cd student-marks-calculator
mvn spring-boot:run
```

Then open **http://localhost:8080** in your browser.

(Alternatively: open the folder in IntelliJ IDEA or VS Code with the Java Extension Pack,
let it import the Maven project, and run `StudentMarksApplication.java` directly.)

## Where each Java basic lives

| Concept        | File | What to look for |
|----------------|------|-------------------|
| Variables & Data Types | `model/Student.java` | `String name`, `int numberOfSubjects`, `double[] marks` |
| Arrays | `model/Student.java`, `service/MarksService.java` | `marks[]` array holds every subject's score |
| Loops | `service/MarksService.java` | `for` loops in `calculateTotal`, `findHighestMark`, `findLowestMark` |
| Operators | `service/MarksService.java` | `+=`, `/`, `>=`, `>`, `<`, ternary `?:` |
| If / Else | `service/MarksService.java` | `calculateGrade()` — grade boundaries |
| Switch | `service/MarksService.java` | `getRemark()` — grade letter → message |
| Methods | `service/MarksService.java` | every calculation is its own method, called from the controller |

## Request flow

1. `GET /` → `index.html` — enter name + number of subjects
2. `POST /generate-form` → `marksForm.html` — a Thymeleaf loop (`th:each`) generates one input box per subject
3. `POST /calculate` → marks arrive as a Java `double[]` array → `MarksService` runs the loops/if-else/switch → `result.html` shows the report

## Next steps to extend it yourself (good practice!)

- Add subject **names** (not just "Subject 1, 2, 3") — array of Strings
- Store multiple students in an `ArrayList<Student>` and show a class ranking
- Add input validation (marks between 0–100) with proper error messages
- Persist results in a database (Spring Data JPA) instead of recalculating each time
