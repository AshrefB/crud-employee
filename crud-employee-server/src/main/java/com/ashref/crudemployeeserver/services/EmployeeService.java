package com.ashref.crudemployeeserver.services;

import java.util.List;
import java.util.Optional;

import com.ashref.crudemployeeserver.dto.EmployeeDTO;

public interface EmployeeService {
	void createEmployee(EmployeeDTO employee);
	void updateEmployee(EmployeeDTO employee);
	void deleteEmployee(Long i);
	Optional<EmployeeDTO> getEmployee(Long id);
	List<EmployeeDTO> getAllEmployees();
}
