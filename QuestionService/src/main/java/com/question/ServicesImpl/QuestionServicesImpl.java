package com.question.ServicesImpl;

import com.question.Entites.Question;
import com.question.Repository.QuestionRepository;
import com.question.Services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServicesImpl implements QuestionServices {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuetion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> Getall() {
        return questionRepository.findAll();
    }

    @Override
    public Question getbyid(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Quetion is not found"));
    }

    @Override
    public List<Question> findByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
