package com.ashref.crudemployeeserver.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashref.crudemployeeserver.dto.EmployeeDTO;
import com.ashref.crudemployeeserver.payload.ResponseMessage;
import com.ashref.crudemployeeserver.services.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<>(new ResponseMessage("CREATED ^_^"), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>(new ResponseMessage("UPDATED ^_^"), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(new ResponseMessage("DELETED ^_^"), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.getEmployee(id).get(), HttpStatus.OK);
	}
	
	@GetMapping({"", "/"})
	public ResponseEntity<?> getEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
}
