package org.jsp.question.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.question.entity.Question;

public interface QuestionDao {

	Question saveQuestion(Question question);

	List<Question> findAllQuestions();

	Optional<Question> findQuestionById(int id);

	List<Question> findAllActiveQuestions();

	List<Question> takeQuiz();


}
