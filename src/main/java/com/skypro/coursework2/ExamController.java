package com.skypro.coursework2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/")

public class ExamController {
    ExaminerService examinerService = new ExaminerService() {


       @GetMapping()
        public Collection<Question> getQuestions(@RequestParam int amount) {
            return examinerService.getQuestions(amount);
        }
    };

}
