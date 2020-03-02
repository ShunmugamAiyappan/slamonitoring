package com.example.slamonitoring.controller;

import com.example.slamonitoring.exception.ResourceNotFoundException;
import com.example.slamonitoring.model.TaskEvents;
import com.example.slamonitoring.repository.TaskEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TaskEventsController {

    @Autowired
    private TaskEventsRepository taskEventsRepository;

//    @GetMapping("/questions")
//    public Page<Question> getQuestions(Pageable pageable) {
//        return questionRepository.findAll(pageable);
//    }


    //@PostMapping("/taskEvents")
    public TaskEvents createTaskEvents(TaskEvents taskEvent) {
        System.out.println("in control");
     // return taskEvent;
        return taskEventsRepository.save(taskEvent);
    }

//    @PutMapping("/questions/{questionId}")
//    public Question updateQuestion(@PathVariable Long questionId,
//                                   @Valid @RequestBody Question questionRequest) {
//        return questionRepository.findById(questionId)
//                .map(question -> {
//                    question.setTitle(questionRequest.getTitle());
//                    question.setDescription(questionRequest.getDescription());
//                    return questionRepository.save(question);
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
//
//
//    @DeleteMapping("/questions/{questionId}")
//    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
//        return questionRepository.findById(questionId)
//                .map(question -> {
//                    questionRepository.delete(question);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
}
