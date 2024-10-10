package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.EmployeeDto;

public interface IEmployeesService {

	public List<EmployeeDto> getEmployees() throws Exception;

	public EmployeeDto getEmployee(int id) throws Exception;

}
