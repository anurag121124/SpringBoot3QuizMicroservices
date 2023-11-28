package com.quiz.Services;

import com.quiz.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICES")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionofQuiz(@PathVariable Long quizId);

}
