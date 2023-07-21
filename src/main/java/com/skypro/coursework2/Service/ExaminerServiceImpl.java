package com.skypro.coursework2.Service;

import com.skypro.coursework2.ExaminerService;
import com.skypro.coursework2.Exception.StorageException;
import com.skypro.coursework2.Question;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


@Service
@Scope("singleton")
public class ExaminerServiceImpl implements ExaminerService {
    private JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    Random random = new Random();

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.questions.size()) {
            throw new StorageException();
        }
        Set<Question> examinerSet = new HashSet<>();

        while (amount > 0 && amount <= javaQuestionService.questions.size()) {
            Question q = javaQuestionService.getRandomQuestion();
            examinerSet.add(q);
            amount++;

        }

        return examinerSet;
    }
}
