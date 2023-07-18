package com.skypro.coursework2.Controllers;

import com.skypro.coursework2.ExaminerService;
import com.skypro.coursework2.Service.ExaminerServiceImpl;
import com.skypro.coursework2.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")

public class ExamController {
    ExaminerService examinerService = new ExaminerServiceImpl();

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping()
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }


}