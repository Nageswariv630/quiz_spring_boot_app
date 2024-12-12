package org.jsp.question.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.question.dao.QuestionDao;
import org.jsp.question.dto.QuestionDto;
import org.jsp.question.dto.QuizResponse;
import org.jsp.question.entity.Question;
import org.jsp.question.exceptionclasses.InvalidQuestionIdException;
import org.jsp.question.exceptionclasses.NoQuestionFoundException;
import org.jsp.question.responsestructure.ResponseStructure;
import org.jsp.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class QuestionServiceImpl implements QuestionService{
@Autowired
private QuestionDao dao;
	@Override
	public ResponseEntity<?> saveQuestion(Question question) {
		question=dao.saveQuestion(question); 
//		ResponseStructure<Question>structure=new ResponseStructure<>();
//		structure.setHttpStatus(HttpStatus.OK.value());
//		structure.setMessage("question saved successfully");
//		structure.setBody(question);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value())
				.message("Question saved successfully").body(question).build());
	}
	@Override
	public ResponseEntity<?> findAllQuestions() {
//		List<Question>questions=dao.findAllQuestions();
		List<Question>questions=dao.findAllActiveQuestions();
		List<QuestionDto>dtolist=new ArrayList<>();
		for(Question q:questions) {
			dtolist.add(new QuestionDto(q.getTitle(), q.getA(), q.getB(), q.getC(), q.getD()));
		}
		if(dtolist.isEmpty()) {
			throw NoQuestionFoundException.builder().message("No Question Found In the Database..").build();
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value())
				.message("All Questions Found Successfully").body(dtolist).build());
	}
	
	@Override
	public ResponseEntity<?> findQuestionById(int id) {
		Optional<Question>optional=dao.findQuestionById(id);
		if(optional.isEmpty()) 
			throw InvalidQuestionIdException.builder().
			message("Invalid question Id").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value())
				.message("Question Found Successfully").body(optional.getClass()).build());
	}
	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses) {
		int c=0;
		for(QuizResponse qr:quizResponses) {
			Optional<Question> q=dao.findQuestionById(qr.getId());
			if(q.isEmpty()) 
				throw InvalidQuestionIdException.builder().message("Invalid question id unable to calculate").build();
			Question question=q.get();
			if(question.getAns().equalsIgnoreCase(qr.getAns())) {
				c++;
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().
				httpStatus(HttpStatus.OK.value()).message("submission successfull").body("your score:"+c).build());
	}
	@Override
	public ResponseEntity<?> takeQuiz() {
		List<Question>questions=dao.takeQuiz();
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
					.httpStatus(HttpStatus.OK.value())
					.message("take quiz").body(questions).build()); 
	
	}

	

}













