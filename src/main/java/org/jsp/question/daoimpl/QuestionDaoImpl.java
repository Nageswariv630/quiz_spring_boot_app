package org.jsp.question.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.question.dao.QuestionDao;
import org.jsp.question.entity.Question;
import org.jsp.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
@Repository
public class QuestionDaoImpl implements QuestionDao{
    @Autowired
    private QuestionRepository repository;
	@Override
	public Question saveQuestion(Question question) {
		return repository.save(question);
	}
	@Override
	public List<Question> findAllQuestions() {
		return repository.findAll();
	}
	@Override
	public Optional<Question> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	@Override
	public List<Question> findAllActiveQuestions() {
		return repository.findAllActiveQuestions();
	}
	@Override
	public List<Question> takeQuiz() {
		return repository.findRandomQuestions(PageRequest.of(0, 5));
	}

}
