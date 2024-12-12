package org.jsp.question.daoimpl;

import org.jsp.question.dao.UserDao;
import org.jsp.question.entity.User;
import org.jsp.question.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao {
@Autowired
private UserRepository repository;
	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

}
