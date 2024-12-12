package org.jsp.question.service;

import java.util.List;

import org.jsp.question.dto.QuizResponse;
import org.jsp.question.entity.Question;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> saveQuestion(Question question);

	ResponseEntity<?> findAllQuestions();


	ResponseEntity<?> findQuestionById(int id);

	ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses);


	ResponseEntity<?> takeQuiz();



	
	

}
