package com.ems.api.service;

import java.util.List;
import java.util.Optional;

import com.ems.api.entity.Employee;

public interface EmployeeService {
	
	Employee add(Employee emp);
	Optional<Employee> getByID(Long id);
	List<Employee> getAll();
	Optional<Employee> delete(Long id);
	Employee update(Employee emp,Long id);

}
