package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.demo.dto.EmployeeDto;

@Service
public class EmployeesService implements IEmployeesService {

	private static final String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

	private final RestClient restClient;

	private static final List<EmployeeDto> EMPLOYEES_DB = new ArrayList<>();

	static {
		EMPLOYEES_DB.add(new EmployeeDto(1, "Avuuna, the Light of Dawn", 1800000));
		EMPLOYEES_DB.add(new EmployeeDto(2, "Nailuj, Herald of the Titans", 2000000));
	}

	public EmployeesService(RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder.baseUrl(BASE_URL).build();
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		return EMPLOYEES_DB;
	}

	@Override
	public EmployeeDto getEmployee(int id) {
		EmployeeDto resp = null;
		for (int i = 0; i < EMPLOYEES_DB.size() && resp == null; i++) {
			if (EMPLOYEES_DB.get(i).getId() == id) {
				resp = EMPLOYEES_DB.get(i);
			}
		}
		return resp;
	}

}
