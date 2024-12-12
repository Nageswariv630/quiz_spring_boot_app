package org.jsp.question.repository;

import org.jsp.question.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	User save(User user);

}
