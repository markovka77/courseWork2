package com.skypro.coursework2;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
