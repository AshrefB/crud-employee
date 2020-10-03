package com.ashref.crudemployeeserver.services.jpa;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ashref.crudemployeeserver.dto.EmployeeDTO;
import com.ashref.crudemployeeserver.entities.Employee;
import com.ashref.crudemployeeserver.repositories.EmployeeRepository;
import com.ashref.crudemployeeserver.services.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final ModelMapper mapper;
	
	@Override
	public void createEmployee(EmployeeDTO employee) {
		Employee e = mapper.map(employee, Employee.class);
		employeeRepository.save(e);
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		Employee e = employeeRepository.findById(employee.getId())
					.orElseThrow(() -> new NoSuchElementException("Employee not found with ID:"+employee.getId()));
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setEmail(employee.getEmail());
		e.setPhone(employee.getPhone());
		e.setDepartment(employee.getDepartment());
		employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee e = employeeRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Employee not found with ID:"+id));
		employeeRepository.delete(e);
	}

	@Override
	public Optional<EmployeeDTO> getEmployee(Long id) {
		Employee e = employeeRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Employee not found with ID:"+id));
		return Optional.of(mapper.map(e, EmployeeDTO.class));
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return Arrays.asList(mapper.map(employees, EmployeeDTO[].class));
	}
	
}
