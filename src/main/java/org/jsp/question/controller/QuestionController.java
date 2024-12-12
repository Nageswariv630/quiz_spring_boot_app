package org.jsp.question.controller;

import java.util.List;

import org.jsp.question.dto.QuizResponse;
import org.jsp.question.entity.Question;
import org.jsp.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	private QuestionService service;
	@PostMapping
	public ResponseEntity<?>saveQuestion(@RequestBody Question question){
		return service.saveQuestion(question);
		
	}
	@GetMapping
	public ResponseEntity<?>findAllQuestions(){
		return service.findAllQuestions();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>findQuestionById(@PathVariable int id){
		return service.findQuestionById(id);
	}
	//take quiz
	@GetMapping("/take-quiz")
	public ResponseEntity<?> takeQuiz() {
	    return service.takeQuiz();
	}

	
	//submit-quiz
	@PostMapping("/submit-quiz")
	public ResponseEntity<?>submitQuiz(@RequestBody List<QuizResponse> quizResponses){
		
		return service.submitQuiz(quizResponses);
		
	}

}











