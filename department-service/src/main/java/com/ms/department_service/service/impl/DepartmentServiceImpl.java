package com.ms.department_service.service.impl;

import com.ms.department_service.dto.DepartmentDto;
import com.ms.department_service.entity.Department;
import com.ms.department_service.repository.DepartmentRepository;
import com.ms.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
         return  modelMapper
                 .map(departmentRepository
                         .save(modelMapper.map(departmentDto , Department.class)) , DepartmentDto.class);

    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        return modelMapper.map(departmentRepository.findDepartmentByDepartmentCode(departmentCode) , DepartmentDto.class);
    }
}
