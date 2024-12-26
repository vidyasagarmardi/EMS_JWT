package com.ems.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.api.entity.Employee;
import com.ems.api.repository.EmployeeRepo;
import com.ems.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee add(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public Optional<Employee> getByID(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Employee> delete(Long id) {
		Optional<Employee> delEmp = repo.findById(id);
		repo.deleteById(id);
		return delEmp;
	}

	@Override
	public Employee update(Employee emp,Long id) {
		Employee existingEmp = repo.findById(id).orElseThrow(null);
		existingEmp.setFirstName(emp.getFirstName());
		existingEmp.setMiddleName(emp.getMiddleName());
		existingEmp.setLastName(emp.getLastName());
		existingEmp.setEmail(emp.getEmail());
		existingEmp.setAddress(emp.getAddress());
		existingEmp.setPhone(emp.getPhone());
		repo.save(existingEmp);
		return existingEmp;
	}

}
