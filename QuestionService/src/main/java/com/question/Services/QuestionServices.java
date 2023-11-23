package com.question.Services;

import com.question.Entites.Question;

import java.util.List;

public interface QuestionServices {

    //Create
    Question createQuetion(Question question);

    //getAll

    List<Question>Getall();

    //Getbyid
    Question getbyid(Long id);

    //GetQuiz

    List<Question> findByQuizId(Long quizId);
}
