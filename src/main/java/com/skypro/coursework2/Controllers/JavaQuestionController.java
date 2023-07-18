package com.skypro.coursework2.Controllers;

import com.skypro.coursework2.Service.JavaQuestionService;
import com.skypro.coursework2.Question;
import com.skypro.coursework2.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    QuestionService questionService = new JavaQuestionService();

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, String answer) {
        return questionService.add(new Question(question, answer));
    }


    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, String answer) {
        return questionService.remove(new Question(question, answer));
    }


    @GetMapping
    public Collection getQuestions() {

        return questionService.getAll();
    }


}
