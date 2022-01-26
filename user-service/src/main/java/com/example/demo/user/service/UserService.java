package com.example.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.valueobject.Department;
import com.example.demo.user.valueobject.ResponseTemplateValueObject;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateValueObject getUserWithDepartment(Long userId) {
		// TODO Auto-generated method stub
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateValueObject vo = new ResponseTemplateValueObject();
		User user = userRepository.findByUserId(userId);
		//Making the RestCall for calling the other microservices to get the Department details
		Department department = 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
		
		vo.setUser(user);				//Setting the user data in the view
		vo.setDepartment(department);	//setting the department in the view
		return vo;
	}
		
}
