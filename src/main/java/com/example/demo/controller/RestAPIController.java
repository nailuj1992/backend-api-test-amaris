package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.services.IEmployeesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	private IEmployeesService employeesService;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, World!";
	}

	@GetMapping("/employees")
	public List<EmployeeDto> getEmployees() throws Exception {
		return employeesService.getEmployees();
	}

	@GetMapping("/employee/{id}")
	public EmployeeDto getEmployee(@PathVariable int id) throws Exception {
		return employeesService.getEmployee(id);
	}

}
