package com.clo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clo.model.Evaluation;
import com.clo.model.Student;

@Controller
public class EvaluationController {

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/evaluate")
    public String evaluate(
            @RequestParam("assessmentType") String assessmentType,
            @RequestParam("totalStudents") @Min(1) int totalStudents,
            @RequestParam MultiValueMap<String, String> formData,
            Model model) {

        Evaluation evaluation = new Evaluation(assessmentType, totalStudents);

        for (int i = 0; i < totalStudents; i++) {
            List<Double> scores = new ArrayList<>();
            int cloCount = evaluation.getMaxMarksPerCLO().size();
            for (int j = 0; j < cloCount; j++) {
                String paramName = "student_" + i + "_clo_" + j;
                String scoreStr = formData.getFirst(paramName);
                if (scoreStr == null || scoreStr.isEmpty()) {
                    model.addAttribute("error", "Missing score for student " + (i + 1) + ", CLO " + (j + 1));
                    return "form";
                }
                try {
                    double score = Double.parseDouble(scoreStr);
                    if (score < 0 || score > evaluation.getMaxMarksPerCLO().get(j)) {
                        model.addAttribute("error", "Invalid score for student " + (i + 1) + ", CLO " + (j + 1));
                        return "form";
                    }
                    scores.add(score);
                } catch (NumberFormatException e) {
                    model.addAttribute("error", "Invalid number format for student " + (i + 1) + ", CLO " + (j + 1));
                    return "form";
                }
            }
            Student student = new Student(i + 1, scores);
            evaluation.addStudent(student);
        }

        evaluation.calStdPer();
        List<Double> classAverages = evaluation.calculateClassAverages();
        List<Boolean> fulfillment = evaluation.checkFulfillment(classAverages);

        model.addAttribute("students", evaluation.getStudents());
        model.addAttribute("classAverages", classAverages);
        model.addAttribute("fulfillment", fulfillment);
        model.addAttribute("assessmentType", assessmentType);

        return "result";
    }
}
