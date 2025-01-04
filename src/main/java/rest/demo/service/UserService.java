package rest.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.demo.model.User;
import rest.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public User getUserDetail(String inputUser) {
		return repository.findByUserName(inputUser);
	}
}
