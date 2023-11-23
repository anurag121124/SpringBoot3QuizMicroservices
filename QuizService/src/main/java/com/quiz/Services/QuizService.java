package com.quiz.Services;

import com.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz>get();

    Quiz getbyid(Long id);



}
