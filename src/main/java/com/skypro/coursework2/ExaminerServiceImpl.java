package com.skypro.coursework2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService{
    QuestionService questionService = new JavaQuestionService();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> examinerList= new ArrayList<>(List.of());
        Question q = questionService.getRandomQuestion();
        for (int i = 0; i < amount; i++) {
            examinerList.add(q);

        }
        return examinerList;
    }
}
