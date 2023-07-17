package com.skypro.coursework2;

import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface  ExaminerService{
     Collection<Question>getQuestions(int amount);
}
