package org.jsp.question.dao;

import org.jsp.question.entity.Authentication;
import org.jsp.question.entity.User;

public interface UserDao {

	User saveUser(User user);

	Authentication loginUser(Authentication auth);

}
