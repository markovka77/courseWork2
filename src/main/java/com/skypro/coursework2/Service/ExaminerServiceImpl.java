package com.skypro.coursework2.Service;

import com.skypro.coursework2.*;
import com.skypro.coursework2.Exception.StorageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static com.skypro.coursework2.Service.JavaQuestionService.questions;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    QuestionService questionService = new JavaQuestionService();
    Random random = new Random();

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questions.size()) {
            throw new StorageException();
        }
        List<Question> examinerList = new ArrayList<>(List.of());
        int a = 0;
        while (amount > a) {
            Question q = questionService.getRandomQuestion();
            examinerList.add(q);
            a++;
        }

        return examinerList;
    }
}
