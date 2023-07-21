package com.skypro.coursework2.Service;

import com.skypro.coursework2.Question;
import com.skypro.coursework2.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question e = new Question(question, answer);
        questions.add(e);
        return e;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;

    }

    @Override
    public Question getRandomQuestion() {
        int tmp = 0;
        Random random = new Random();
        if (questions.size() < Integer.MAX_VALUE) {
            tmp = questions.size();
        }
        int e = random.nextInt(tmp);

        return questions.stream()
                .toList()
                .get(e);
    }


}
