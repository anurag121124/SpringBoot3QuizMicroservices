package com.question.Controller;

import com.question.Entites.Question;
import com.question.Services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServices questionServices;

    @PostMapping
    public ResponseEntity<Question> createQuetion(@RequestBody Question question){
        return ResponseEntity.status(HttpStatus.CREATED).body(question);
    }

}
