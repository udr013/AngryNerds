package eu.programit.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.programit.domain.User;
import eu.programit.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Boolean deleteUser(Integer id) {
		User temp = userRepository.findOne(id);
		if (temp != null) {
			userRepository.delete(id);
			return true;
		}
		return false;
	}

	public User editUser(User user) {
		return userRepository.save(user);
	}

	public User findUser(Integer id) {
		return userRepository.findOne(id);
	}

	public Collection<User> getAllUsers() {
		return (Collection<User>) userRepository.findAll();
	}

	public User findByName(String name) {
		return userRepository.findByUsername(name);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
