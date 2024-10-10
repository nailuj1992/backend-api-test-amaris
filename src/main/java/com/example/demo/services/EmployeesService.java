package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.EmployeeDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeesService implements IEmployeesService {

	private static final String BASE_URL = "https://hub.dummyapis.com/";
	private static final String EMPLOYEE_ENDPOINT = "/employee";

	private final RestClient restClient;
	private final RestTemplate restTemplate;
	
	private static final List<EmployeeDto> EMPLOYEES_DB = new ArrayList<>();

	static {
		EMPLOYEES_DB.add(new EmployeeDto(1001, "https://hub.dummyapis.com/Image?text=DG&height=120&width=120", "Dominique", "Graham", "Dominique.Graham@dummyapis.com", "4015296050", 22, "04/10/2002", "Address1", 1.0));
		EMPLOYEES_DB.add(new EmployeeDto(1002, "https://hub.dummyapis.com/Image?text=DD&height=120&width=120", "Devonte", "Dickens", "Devonte.Dickens@dummyapis.com", "4255497188", 36, "15/02/1988", "Address2", 2.0));
		EMPLOYEES_DB.add(new EmployeeDto(1003, "https://hub.dummyapis.com/Image?text=AV&height=120&width=120", "Alexandra", "Von", "Alexandra.Von@dummyapis.com", "4260996406", 85, "09/04/1939", "Address3", 3.0));
		EMPLOYEES_DB.add(new EmployeeDto(1004, "https://hub.dummyapis.com/Image?text=TL&height=120&width=120", "Thora", "Larkin", "Thora.Larkin@dummyapis.com", "4593698154", 51, "19/03/1973", "Address4", 4.0));
	}

	public EmployeesService(RestTemplateBuilder restTemplateBuilder, RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder.baseUrl(BASE_URL).build();
		this.restTemplate = restTemplateBuilder.build();
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//		messageConverters.add(converter);
//		this.restTemplate.setMessageConverters(messageConverters);
	}

	@Override
	public List<EmployeeDto> getEmployees() throws Exception {
//		// Create headers to specify that you accept JSON
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//
//		// HttpEntity with headers
//		HttpEntity<String> entity = new HttpEntity<>(headers);
//
////		ResponseEntity<List<EmployeeDto>> responseEntity = restTemplate.exchange(BASE_URL + EMPLOYEE_ENDPOINT,
////				HttpMethod.GET, entity, new ParameterizedTypeReference<List<EmployeeDto>>() {
////				});
//		String body = restClient.get().uri(EMPLOYEE_ENDPOINT).retrieve().body(String.class);
////		if (responseEntity.getStatusCode() == HttpStatus.OK) {
////			String body = responseEntity.getBody();
////			ObjectMapper om = new ObjectMapper();
////			List<EmployeeDto> resp = om.readValue(body, new TypeReference<List<EmployeeDto>>() {
////			});
////			System.out.println(resp.size());
////			return resp;
////		}
////		System.out.println(responseEntity.getStatusCode().toString());
//		
//		System.out.println(body);
//		ObjectMapper om = new ObjectMapper();
//		List<EmployeeDto> resp = om.readValue(body, new TypeReference<List<EmployeeDto>>() {
//		});
//		System.out.println(resp.size());
//		return resp;
		
		return EMPLOYEES_DB;
	}

	@Override
	public EmployeeDto getEmployee(int id) throws Exception {
		List<EmployeeDto> employees = getEmployees();
		EmployeeDto resp = null;
		for (int i = 0; i < employees.size() && resp == null; i++) {
			if (employees.get(i).getId() == id) {
				resp = employees.get(i);
			}
		}
		return resp;
	}

}
