package org.jsp.question.serviceimpl;

import org.jsp.event.responseStructure.ResponseStructure;
import org.jsp.question.dao.UserDao;
import org.jsp.question.entity.Authentication;
import org.jsp.question.entity.User;
import org.jsp.question.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().
				httpStatus(HttpStatus.OK.value()).message("User saved successfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> loginUser(Authentication auth) {
		auth=dao.loginUser(auth);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().
				httpStatus(HttpStatus.OK.value()).message("User login successfully").body(auth).build());
	}
	

}
