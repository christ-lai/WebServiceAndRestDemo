 package com.celnet.restservice.restServiceImpl;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.entity.User;
import com.celnet.repository.UserRepository;
import com.celnet.restservice.UserService;

@Service
public class UserServiceImpl implements UserService{
   @Autowired
    private UserRepository userRepository;
	@Override
	public List<User> findAll() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}
     
 }