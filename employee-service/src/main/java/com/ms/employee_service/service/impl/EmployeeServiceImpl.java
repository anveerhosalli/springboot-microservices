package com.ms.employee_service.service.impl;

import com.ms.employee_service.dto.APIResponseDto;
import com.ms.employee_service.dto.DepartmentDto;
import com.ms.employee_service.dto.EmployeeDto;
import com.ms.employee_service.entity.Employee;
import com.ms.employee_service.repository.EmployeeRepository;
import com.ms.employee_service.service.APIClient;
import com.ms.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

//    private RestTemplate restTemplate;

//    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        return  modelMapper.map(employeeRepository.save(modelMapper.map(employeeDto , Employee.class)), EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployee(Long id) {

        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = modelMapper.map(employee ,EmployeeDto.class);
        //Rest Template
//        ResponseEntity<DepartmentDto>  responseEntity =  restTemplate
//                .getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode() ,
//                        DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
        //webclient
//        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        //s c openfeign
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        return new APIResponseDto(employeeDto , departmentDto);
    }
}
