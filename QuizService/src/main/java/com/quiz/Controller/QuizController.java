package com.quiz.Controller;

import com.quiz.Services.QuizService;
import com.quiz.entity.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping()
    public ResponseEntity<Quiz> CreateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.add(quiz));
    }

    @GetMapping()
    public ResponseEntity<List<Quiz>> getall(){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz>getbyid(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getbyid(id));
    }


}
