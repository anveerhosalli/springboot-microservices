package com.ms.department_service.service;

import com.ms.department_service.dto.DepartmentDto;
import com.ms.department_service.entity.Department;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto  departmentDto);

    DepartmentDto getDepartment(String departmentCode);
}
