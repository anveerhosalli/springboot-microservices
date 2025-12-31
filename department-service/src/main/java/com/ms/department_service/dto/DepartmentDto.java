package com.ms.department_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
public class DepartmentDto {

    Long id ;
    String departmentName;
    String departmentDescription;
    String departmentCode;
}
