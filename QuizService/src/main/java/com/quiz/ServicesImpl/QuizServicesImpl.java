package com.quiz.ServicesImpl;

import com.quiz.Repository.QuizRepository;
import com.quiz.Services.QuizService;
import com.quiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServicesImpl implements QuizService {

    private QuizRepository quizRepository;


    public QuizServicesImpl(QuizRepository quizRepository) {
        this.quizRepository=quizRepository;

    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getbyid(Long id) {
        return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not Found"));

    }


}
