package com.skypro.coursework2;

import com.skypro.coursework2.Service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
     static Set<Question> testSet = new HashSet<>();

    @Mock
    JavaQuestionService questionsMock;
    @InjectMocks
    JavaQuestionService javaQuestionService;


    @ParameterizedTest
    @CsvSource({"'What?','Nothing!'"})
    void add(String question,String answer) {
        Question e = new Question(question, answer);
        testSet.add(e);
        Assertions.assertEquals(e,testSet.stream().findFirst().get());

    }

    @Test
    void testAdd() {
        Question question = new Question("Question","Answer");
        testSet.add(question);
        Assertions.assertEquals(question,testSet.stream().findFirst().get());

    }

    @Test
    void remove() {
        Question question = new Question("Question","Answer");
        testSet.remove(question);
        assertNotEquals(testSet,question);
    }


    @Test
    void getAll(){
        when(questionsMock.getAll()).thenReturn(testSet);
        Object actual = questionsMock.getAll();
        assertEquals(actual,testSet);
    }




}