package org.jsp.question.service;

import org.jsp.question.entity.Authentication;
import org.jsp.question.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> loginUser(Authentication auth);
	

}
