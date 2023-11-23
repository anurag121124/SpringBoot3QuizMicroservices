package com.question.Controller;

import com.question.Entites.Question;
import com.question.Services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServices questionServices;

    @PostMapping
    public ResponseEntity<Question> createQuetion(@RequestBody Question question){
        return ResponseEntity.status(HttpStatus.CREATED).body(questionServices.createQuetion(question));
    }

    @GetMapping
    public ResponseEntity<List<Question>>getall(){
        return ResponseEntity.status(HttpStatus.OK).body(questionServices.Getall());
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuetionbyid(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.OK).body(questionServices.getbyid(id));
    }


    @GetMapping("/quiz/{quizId}")
    public ResponseEntity getQuizById(@PathVariable Long quizId){
        return  ResponseEntity.status(HttpStatus.OK).body(questionServices.findByQuizId(quizId));
    }
}
