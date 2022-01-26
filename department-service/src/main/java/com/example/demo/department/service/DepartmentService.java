package com.example.demo.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.department.entity.Department;
import com.example.demo.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department) ;
	}

	public Department findDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		log.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}
	
}
