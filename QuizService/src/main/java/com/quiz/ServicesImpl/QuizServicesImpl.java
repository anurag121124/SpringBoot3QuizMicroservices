package com.quiz.ServicesImpl;

import com.quiz.Repository.QuizRepository;
import com.quiz.Services.QuestionClient;
import com.quiz.Services.QuizService;
import com.quiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServicesImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServicesImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionofQuiz(quiz.getId()));
            return quiz; // Fix: Return the modified quiz, not the entire list
        }).collect(Collectors.toList()); // Fix: Add a semicolon at the end
        return newQuizList;
    }

    @Override
    public Quiz getbyid(Long id) {
      Quiz quiz =  quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not Found"));
      quiz.setQuestions(questionClient.getQuestionofQuiz(quiz.getId()));
      return quiz;
    }


}
