package com.ms.department_service.controller;

import com.ms.department_service.dto.DepartmentDto;
import com.ms.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;


    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto) , HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public  ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code")  String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartment(departmentCode) , HttpStatus.OK);
    }


}
